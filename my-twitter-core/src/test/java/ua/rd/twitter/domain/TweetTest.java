package ua.rd.twitter.domain;

import org.junit.Test;
import ua.rd.twitter.domain.util.LikeTestFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TweetTest extends AbstractEntityTest {

    @Test
    public void testAddRetweetShouldModifyRetweetCollection() throws Exception {
        Tweet tweet = new Tweet();
        Retweet retweet = new Retweet();
        tweet.addRetweet(retweet);

        assertThat(tweet.getRetweets().size(), is(1));
        assertTrue(tweet.getRetweets().contains(retweet));
    }

    @Test
    public void getMentionedUserNames() throws Exception {

    }

    @Test
    public void getReplyRecipient() throws Exception {

    }

    @Test
    public void setOwner() throws Exception {

    }

    @Test
    public void setMessage() throws Exception {

    }

    @Test
    public void setLikes() throws Exception {

    }

    @Test
    public void setRetweets() throws Exception {

    }

    @Test
    public void testLikeShouldBeAddedToTheLikesCollection() {
        Tweet tweet = new Tweet();
        Like like = LikeTestFactory.withIds(0L, 0L);
        tweet.like(like);

        assertThat(tweet.getLikes().size(), is(1));
        assertTrue(tweet.getLikes().contains(like));
    }

    @Test
    public void testLikeFromTheSameUserShouldNotAddNewLike() {
        Tweet tweet = new Tweet();
        Like like = LikeTestFactory.withIds(0L, 0L);
        tweet.like(like);
        tweet.like(like);

        assertThat(tweet.getLikes().size(), is(1));
        assertTrue(tweet.getLikes().contains(like));
    }

    @Test
    public void testDislikeShouldRemoveExistingLike() {
        Tweet tweet = new Tweet();
        Like like = LikeTestFactory.withIds(0L, 0L);
        tweet.like(like);
        tweet.dislike(like);

        assertThat(tweet.getLikes().size(), is(0));
        assertFalse(tweet.getLikes().contains(like));
    }

    @Test
    public void testDislikeWhenNoLikesShouldDoNothing() {
        Tweet tweet = new Tweet();
        Like like = LikeTestFactory.withIds(0L, 0L);
        tweet.dislike(like);

        assertThat(tweet.getLikes().size(), is(0));
    }

    @Override
    protected AbstractEntity<Long> create() {
        return new Tweet();
    }
}