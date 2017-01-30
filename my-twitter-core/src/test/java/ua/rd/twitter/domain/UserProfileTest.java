package ua.rd.twitter.domain;

import org.junit.Test;
import ua.rd.twitter.domain.exception.AlreadyFollowingException;
import ua.rd.twitter.domain.exception.SelfFollowException;
import ua.rd.twitter.domain.util.UserProfileTestFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserProfileTest extends AbstractEntityTest {

    @Test(expected = SelfFollowException.class)
    public void testFollowYourself() {
        UserProfile profile = UserProfileTestFactory.withId(1L);
        profile.follow(profile);
    }

    @Test
    public void testFollowShouldAddFollowingToTheCollection() {
        UserProfile profile = UserProfileTestFactory.withId(1L);
        UserProfile someOtherProfile = UserProfileTestFactory.withId(10L);
        profile.follow(someOtherProfile);

        assertThat(profile.getFollowing().size(), is(1));
        assertTrue(profile.getFollowing().contains(someOtherProfile));
    }

    @Test(expected = AlreadyFollowingException.class)
    public void testFollowAlreadyFollowingShouldThrow() {
        UserProfile profile = UserProfileTestFactory.withId(1L);
        UserProfile someOtherProfile = UserProfileTestFactory.withId(10L);
        profile.follow(someOtherProfile);
        profile.follow(someOtherProfile);
    }

    @Override
    protected AbstractEntity<Long> create() {
        return new UserProfile();
    }
}