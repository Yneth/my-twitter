package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Retweet extends Tweet {
    private Tweet tweet;

    public Retweet(Tweet tweet, User user) {
        Objects.requireNonNull(tweet, "Tweet cannot be null.");
        Objects.requireNonNull(user, "User cannot be null.");

        this.setTweet(tweet);
        this.setOwner(user);

        tweet.getRetweets().add(this);
    }
}
