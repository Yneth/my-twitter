package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {
        "profile", "authorities",
})
public class User extends AbstractEntity<Long> {
    private String login;

    private String password;

    private UserProfile profile;

    private Set<Authority> authorities = new HashSet<>();
}
