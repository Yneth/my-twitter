package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Like extends AbstractEntity<LikeId> {
    private LikeId likeId;

    private Tweet tweet;

    private User owner;

    public static Like from(User user, Tweet tweet) {
        Like like = new Like();
        like.setOwner(user);
        like.setTweet(tweet);
        return like;
    }
}
