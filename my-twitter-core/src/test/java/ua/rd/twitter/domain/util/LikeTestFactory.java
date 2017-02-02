package ua.rd.twitter.domain.util;

import ua.rd.twitter.domain.Like;
import ua.rd.twitter.domain.Tweet;

public final class LikeTestFactory {

    private LikeTestFactory() {
    }

    public static Like withIds(Long ownerId, Long tweetId) {
        Like like = new Like();
        like.setOwner(UserProfileTestFactory.withId(ownerId));

        Tweet tweet = new Tweet();
        tweet.setId(tweetId);
        like.setTweet(tweet);

        return like;
    }
}
