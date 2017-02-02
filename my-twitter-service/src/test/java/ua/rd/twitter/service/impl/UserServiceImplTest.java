package ua.rd.twitter.service.impl;

import org.junit.Before;
import org.junit.Test;
import ua.rd.twitter.domain.UserProfile;
import ua.rd.twitter.domain.exception.AlreadyFollowingException;
import ua.rd.twitter.domain.exception.SelfFollowException;
import ua.rd.twitter.service.UserService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserServiceImplTest {
    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void follow() throws Exception {

    }

    @Test(expected = SelfFollowException.class)
    public void testFollowYourself() {
        UserProfile profile = createUserWithId(1L);
        userService.follow(profile, profile);
    }

    @Test
    public void testFollowShouldAddFollowingToTheCollection() {
        UserProfile profile = createUserWithId(1L);
        UserProfile someOtherProfile = createUserWithId(10L);
        userService.follow(profile, someOtherProfile);

        assertThat(profile.getFollowing().size(), is(1));
        assertTrue(profile.getFollowing().contains(someOtherProfile));
    }

    @Test(expected = AlreadyFollowingException.class)
    public void testFollowAlreadyFollowingShouldThrow() {
        UserProfile profile = createUserWithId(1L);
        UserProfile someOtherProfile = createUserWithId(10L);

        userService.follow(profile, someOtherProfile);
        userService.follow(profile, someOtherProfile);
    }

    @Test
    public void testFollowNonPersistentUserShouldNotBeFollowed() {
        UserProfile toFollow = new UserProfile();
        UserProfile follower = createUserWithId(10L);
        userService.follow(follower, toFollow);

        assertThat(toFollow.getFollowers().size(), is(0));
        assertThat(follower.getFollowing().size(), is(0));
    }

    @Test
    public void testNotPersistedUserFollowShouldDoNothing() {
        UserProfile toFollow = createUserWithId(10L);
        UserProfile follower = new UserProfile();
        userService.follow(follower, toFollow);

        assertThat(toFollow.getFollowers().size(), is(0));
        assertThat(follower.getFollowing().size(), is(0));
    }

    private UserProfile createUserWithId(Long id) {
        UserProfile profile = new UserProfile();
        profile.setId(id);
        return profile;
    }
}