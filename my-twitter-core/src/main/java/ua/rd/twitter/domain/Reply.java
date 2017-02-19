package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"tweet", "recipient",})
public class Reply extends Tweet {
    private Tweet tweet;

    private UserProfile recipient;
}
