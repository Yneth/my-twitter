package ua.rd.twitter.domain;

import lombok.*;
import ua.rd.twitter.Constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true, exclude = {
        "account", "tweets", "followers", "following",
})
public class UserProfile extends AbstractEntity<Long> {
    private User account;

    private String username;

    private List<Tweet> tweets = new ArrayList<>();

    private Set<UserProfile> followers = new HashSet<>();

    private Set<UserProfile> following = new HashSet<>();

    public UserProfile(String name) {
        this.username = name;
        String usernamePrefix = Constants.USERNAME_PREFIX;
        if (name.startsWith(usernamePrefix)) {
            this.username = name.substring(usernamePrefix.length());
        }
    }
}
