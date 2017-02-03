package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"authorities"})
public class User extends AbstractEntity<Long> {
    private String username;

    private String password;

    private UserProfile profile;

    private String firstName;

    private String lastName;

    private Set<Authority> authorities = new HashSet<>();
}
