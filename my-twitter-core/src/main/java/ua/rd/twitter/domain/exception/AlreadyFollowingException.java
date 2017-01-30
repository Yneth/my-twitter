package ua.rd.twitter.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlreadyFollowingException extends RuntimeException {
    private final Long followerId;
    private final Long followeeId;
}
