package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {
        "account", "tweets", "followers", "following"
})
public class UserProfile extends AbstractEntity<Long> {
    private User account;

    private String firstName;

    private String lastName;

    private String langKey;

    private List<Tweet> replies = new ArrayList<>();

    private List<Tweet> mentions = new ArrayList<>();

    private List<Tweet> tweets = new ArrayList<>();

    private Set<UserProfile> followers = new HashSet<>();

    private Set<UserProfile> following = new HashSet<>();
}
