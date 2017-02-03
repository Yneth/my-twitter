package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ua.rd.twitter.Constants;

import java.util.*;
import java.util.regex.Matcher;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"likes", "retweets"})
public class Tweet extends AbstractEntity<Long> {
    private User owner;

    private String message;

    private Set<Like> likes = new HashSet<>();

    private Collection<Retweet> retweets = new ArrayList<>();

    public void addRetweet(Retweet retweet) {
        retweets.add(retweet);
    }

    public void like(Like like) {
        likes.add(like);
    }

    public void dislike(Like like) {
        likes.remove(like);
    }

    public List<String> getMentionedUserNames() {
        List<String> result = new ArrayList<>();
        if (message != null) {
            Matcher matcher = Constants.USERNAME_PATTERN.matcher(message);
            while (matcher.find()) {
                if (matcher.start() != 0) {
                    result.add(matcher.group());
                }
            }
        }
        return result;
    }

    public Optional<String> getReplyRecipient() {
        Matcher matcher = Constants.USERNAME_PATTERN.matcher(message);
        if (matcher.find() && matcher.start() == 0) {
            Optional.of(matcher.group());
        }
        return Optional.empty();
    }
}
