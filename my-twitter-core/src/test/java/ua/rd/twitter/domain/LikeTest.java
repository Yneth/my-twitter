package ua.rd.twitter.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LikeTest {

    @Test
    public void testFrom() {
        UserProfile user = new UserProfile();
        Tweet tweet = new Tweet();

        Like from = new Like(user, tweet);

        assertTrue(user == from.getOwner());
        assertTrue(tweet == from.getTweet());
    }

    @Test(expected = NullPointerException.class)
    public void testFromUserShouldNotBeNull() {
        new Like(null, new Tweet());
    }

    @Test(expected = NullPointerException.class)
    public void testFromTweetShouldNotBeNull() {
        new Like(new UserProfile(), null);
    }

    @Test(expected = NullPointerException.class)
    public void testFromArgsShouldNotBeNull() {
        new Like(null, null);
    }
}