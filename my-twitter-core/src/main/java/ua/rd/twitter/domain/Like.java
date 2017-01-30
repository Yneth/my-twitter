package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Like extends AbstractEntity<LikeId> {
    private LikeId likeId;

    private Tweet tweet;

    private User owner;

    public static Like from(User user, Tweet tweet) {
        Objects.requireNonNull(user, "User should not be null.");
        Objects.requireNonNull(tweet, "Tweet should not be null");

        Like like = new Like();
        like.setOwner(user);
        like.setTweet(tweet);
        return like;
    }
}
