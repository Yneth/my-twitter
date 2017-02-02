package ua.rd.twitter.domain;

import org.junit.Test;
import ua.rd.twitter.domain.util.LikeTestFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LikeTest {

    @Test
    public void testIdShouldBeExcludedFromEquals() {
        Like like1 = LikeTestFactory.withIds(1L, 1L);
        Like like2 = LikeTestFactory.withIds(2L, 2L);

        assertTrue(like1.equals(like2));
    }

    @Test
    public void testIdShouldBeExcludedFromHashCode() {
        Like like1 = LikeTestFactory.withIds(1L, 1L);
        Like like2 = LikeTestFactory.withIds(2L, 2L);

        assertEquals(like1.hashCode(), like2.hashCode());
    }

    @Test
    public void testFrom() {
        UserProfile user = new UserProfile();
        Tweet tweet = new Tweet();

        Like from = Like.from(user, tweet);

        assertTrue(user == from.getOwner());
        assertTrue(tweet == from.getTweet());
    }

    @Test(expected = NullPointerException.class)
    public void testFromUserShouldNotBeNull() {
        Like.from(null, new Tweet());
    }

    @Test(expected = NullPointerException.class)
    public void testFromTweetShouldNotBeNull() {
        Like.from(new UserProfile(), null);
    }

    @Test(expected = NullPointerException.class)
    public void testFromArgsShouldNotBeNull() {
        Like.from(null, null);
    }
}