package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false, exclude = {"likes", "retweets"})
public class Tweet extends AbstractEntity<Long> {
    private User owner;

    private String text;

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
}
