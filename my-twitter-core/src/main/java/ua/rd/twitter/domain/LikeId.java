package ua.rd.twitter.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeId {
    private Long ownerId;

    private Long tweetId;
}
