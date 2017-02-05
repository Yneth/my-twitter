package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Retweet extends Tweet {
    private Tweet tweet;

    public static Retweet from(Tweet tweet, User user) {
        Objects.requireNonNull(tweet, "Tweet cannot be null.");
        Objects.requireNonNull(user, "User cannot be null.");

        Retweet retweet = new Retweet();
        retweet.setTweet(tweet);
        retweet.setOwner(user);

        tweet.getRetweets().add(retweet);
        return retweet;
    }

    public static Retweet from(Retweet tweet, User user) {
        return from(tweet.getTweet(), user);
    }
}
