package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Retweet extends Tweet {
    private Tweet tweet;

    public static Retweet retweet(Tweet tweet, User user) {
        Retweet retweet = new Retweet();
        retweet.setTweet(tweet);
        retweet.setOwner(user);
        return retweet;
    }
}
