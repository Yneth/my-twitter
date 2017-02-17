package ua.rd.twitter.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RetweetTest {

    @Test
    public void testFromShouldSetCorrectly() {
        Tweet tweet = new Tweet();
        User user = new User();
        Retweet from = new Retweet(tweet, user);

        assertTrue(tweet == from.getTweet());
        assertTrue(user == from.getOwner());
    }

    @Test
    public void testFromShouldAddRetweetToTweet() {
        Tweet tweet = new Tweet();
        User user = new User();
        Retweet from = new Retweet(tweet, user);

        assertThat(tweet.getRetweets().size(), is(1));
        assertTrue(tweet.getRetweets().contains(from));
    }

    @Test(expected = NullPointerException.class)
    public void testFromTweetShouldNotBeNull() {
        new Retweet(null, new User());
    }

    @Test(expected = NullPointerException.class)
    public void testFromUserShouldNotBeNull() {
        new Retweet(new Tweet(), null);
    }

    @Test(expected = NullPointerException.class)
    public void testFromArgsShouldNotBeNull() {
        new Retweet(null, null);
    }
}