package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ua.rd.twitter.domain.exception.AlreadyFollowingException;
import ua.rd.twitter.domain.exception.SelfFollowException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false, exclude = {"tweets", "followers", "following"})
public class UserProfile extends AbstractEntity<Long> {
    private User account;

    private String firstName;

    private String lastName;

    private String langKey;

    private List<Tweet> tweets = new ArrayList<>();

    private Set<UserProfile> followers = new HashSet<>();

    private Set<UserProfile> following = new HashSet<>();

    public void follow(UserProfile that) {
        if (this.getId() == null || that.getId() == null) {
            // TODO: throw exception
            return;
        }
        if (this.getId().equals(that.getId())) {
            throw new SelfFollowException();
        }
        if (following.contains(that)) {
            throw new AlreadyFollowingException(getId(), that.getId());
        }
        following.add(that);
        that.addFollower(this);
    }

    private void addFollower(UserProfile follower) {
        followers.add(follower);
    }
}
