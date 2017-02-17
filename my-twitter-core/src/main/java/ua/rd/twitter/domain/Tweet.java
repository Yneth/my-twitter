package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ua.rd.twitter.Constants;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {
        "likes", "retweets",
})
public class Tweet extends AbstractEntity<Long> {
    protected LocalDateTime creationDateTime;

    protected User owner;

    protected String message;

    protected Set<Like> likes = new HashSet<>();

    protected Collection<Retweet> retweets = new ArrayList<>();

    public List<String> getMentionedUsernames() {
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
}
