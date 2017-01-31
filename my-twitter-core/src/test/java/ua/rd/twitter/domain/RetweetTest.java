package ua.rd.twitter.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RetweetTest extends AbstractEntityTest {

    @Test
    public void testFromShouldSetCorrectly() {
        Tweet tweet = new Tweet();
        User user = new User();
        Retweet from = Retweet.from(tweet, user);

        assertTrue(tweet == from.getTweet());
        assertTrue(user == from.getOwner());
    }

    @Test
    public void testFromShouldAddRetweetToTweet() {
        Tweet tweet = new Tweet();
        User user = new User();
        Retweet from = Retweet.from(tweet, user);

        assertThat(tweet.getRetweets().size(), is(1));
        assertTrue(tweet.getRetweets().contains(from));
    }

    @Test(expected = NullPointerException.class)
    public void testFromTweetShouldNotBeNull() {
        Retweet.from(null, new User());
    }

    @Test(expected = NullPointerException.class)
    public void testFromUserShouldNotBeNull() {
        Retweet.from(new Tweet(), null);
    }

    @Test(expected = NullPointerException.class)
    public void testFromArgsShouldNotBeNull() {
        Retweet.from(null, null);
    }

    @Override
    protected AbstractEntity<Long> create() {
        return new Retweet();
    }
}