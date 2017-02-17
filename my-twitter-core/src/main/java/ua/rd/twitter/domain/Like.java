package ua.rd.twitter.domain;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Like {
    private Tweet tweet;

    private UserProfile owner;

    public static Like from(UserProfile user, Tweet tweet) {
        Objects.requireNonNull(user, "User should not be null.");
        Objects.requireNonNull(tweet, "Tweet should not be null");

        Like like = new Like();
        like.setOwner(user);
        like.setTweet(tweet);
        return like;
    }
}
