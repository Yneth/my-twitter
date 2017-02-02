package ua.rd.twitter.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.rd.twitter.domain.UserProfile;
import ua.rd.twitter.respository.UserProfileRepository;
import ua.rd.twitter.service.UserService;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private UserService userService;

    @Mock
    private UserProfileRepository userProfileRepository;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userProfileRepository);
    }

    @Test
    public void testFollowYourselfShouldDoNothing() {
        UserProfile profile = createUserWithId(1L);
        when(userProfileRepository.findById(anyLong())).
                thenReturn(Optional.of(profile));

        userService.follow(1, 1);
    }

    @Test
    public void testFollowShouldAddToFollowerToFollowers() {
        UserProfile followee = createUserWithId(1L);
        UserProfile follower = createUserWithId(10L);

        when(userProfileRepository.findById(followee.getId())).
                thenReturn(Optional.of(followee));
        when(userProfileRepository.findById(follower.getId())).
                thenReturn(Optional.of(follower));
        userService.follow(follower.getId(), followee.getId());

        assertThat(followee.getFollowers().size(), is(1));
        assertTrue(followee.getFollowers().contains(follower));
    }

    @Test
    public void testFollowShouldAddToFolloweeToFollowing() {
        UserProfile followee = createUserWithId(1L);
        UserProfile follower = createUserWithId(10L);

        when(userProfileRepository.findById(followee.getId())).
                thenReturn(Optional.of(followee));
        when(userProfileRepository.findById(follower.getId())).
                thenReturn(Optional.of(follower));
        userService.follow(follower.getId(), followee.getId());

        assertThat(follower.getFollowing().size(), is(1));
        assertTrue(follower.getFollowing().contains(followee));
    }

    @Test
    public void testFollowTwiceShouldNotAddFolloweeTwice() {
        UserProfile followee = createUserWithId(1L);
        UserProfile follower = createUserWithId(10L);

        when(userProfileRepository.findById(followee.getId())).
                thenReturn(Optional.of(followee));
        when(userProfileRepository.findById(follower.getId())).
                thenReturn(Optional.of(follower));

        userService.follow(follower.getId(), followee.getId());
        userService.follow(follower.getId(), followee.getId());

        assertEquals(1, follower.getFollowing().size());
    }

    @Test
    public void testFollowTwiceShouldNotAddFollowerTwice() {
        UserProfile followee = createUserWithId(1L);
        UserProfile follower = createUserWithId(10L);

        when(userProfileRepository.findById(followee.getId())).
                thenReturn(Optional.of(followee));
        when(userProfileRepository.findById(follower.getId())).
                thenReturn(Optional.of(follower));

        userService.follow(follower.getId(), followee.getId());
        userService.follow(follower.getId(), followee.getId());

        assertEquals(1, followee.getFollowers().size());
    }

    private UserProfile createUserWithId(Long id) {
        UserProfile profile = new UserProfile();
        profile.setId(id);
        return profile;
    }
}