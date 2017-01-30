package ua.rd.twitter.domain;

import org.junit.Test;
import ua.rd.twitter.domain.exception.AlreadyFollowingException;
import ua.rd.twitter.domain.exception.SelfFollowException;

public class UserProfileTest extends AbstractEntityTest {

    @Test(expected = SelfFollowException.class)
    public void testFollowYourself() {
        UserProfile profile = withId(1L);
        profile.follow(profile);
    }

    @Test
    public void testSuccessfulFollow() {
        UserProfile profile = withId(1L);
        UserProfile someOtherProfile = withId(10L);
        profile.follow(someOtherProfile);
    }

    @Test(expected = AlreadyFollowingException.class)
    public void testFollowAlreadyFollowing() {
        UserProfile profile = withId(1L);
        UserProfile someOtherProfile = withId(10L);
        profile.follow(someOtherProfile);
        profile.follow(someOtherProfile);
    }

    @Override
    protected AbstractEntity create() {
        return new UserProfile();
    }

    protected UserProfile withId(Long id) {
        UserProfile profile = new UserProfile();
        profile.setId(id);
        return profile;
    }
}