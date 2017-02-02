package ua.rd.twitter.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LikeTest {

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