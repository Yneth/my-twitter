package ua.rd.twitter.domain.util;

import ua.rd.twitter.domain.Like;
import ua.rd.twitter.domain.LikeId;

public final class LikeTestFactory {

    private LikeTestFactory() {
    }

    public static Like withIds(Long ownerId, Long tweetId) {
        Like like = new Like();
        LikeId likeId = new LikeId();
        likeId.setOwnerId(1L);
        likeId.setTweetId(2L);
        like.setId(likeId);
        return like;
    }
}
