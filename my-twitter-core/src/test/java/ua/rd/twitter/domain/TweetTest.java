package ua.rd.twitter.domain;

import org.junit.Test;
import ua.rd.twitter.domain.util.LikeTestFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class TweetTest {

    @Test
    public void testGetMentionedUserNamesShouldBeEmptyOnEmptyMessage() throws Exception {
        assertTrue(new Tweet().getMentionedUserNames().isEmpty());
    }

    @Test
    public void testGetMentionedUserNamesShouldNotAcceptReply() throws Exception {
        String username = "@someName";
        Tweet tweet = new Tweet();
        tweet.setMessage(username + " sdfkjasbfbsadfkas");

        assertTrue(tweet.getMentionedUserNames().isEmpty());
    }

    @Test
    public void testGetMentionedUserNamesShouldWorkForMultipleMentions() throws Exception {
        String mention1 = "@someName1";
        String mention2 = "@someName2";
        Tweet tweet = new Tweet();
        tweet.setMessage("sdfkjasbfbsadfkas" + mention1 + mention2);

        List<String> mentionedUserNames = tweet.getMentionedUserNames();
        assertEquals(2, mentionedUserNames.size());
        assertTrue(mentionedUserNames.contains(mention1));
        assertTrue(mentionedUserNames.contains(mention2));
    }

    @Test
    public void testGetMentionedUserNamesShouldGetMentionsFromReply() throws Exception {
        String reply = "@someName";
        String mention1 = "@someName1";
        String mention2 = "@someName2";
        Tweet tweet = new Tweet();
        tweet.setMessage(reply + "sdfkjasbfbsadfkas" + mention1 + mention2);

        List<String> mentionedUserNames = tweet.getMentionedUserNames();
        assertEquals(2, mentionedUserNames.size());
        assertTrue(mentionedUserNames.contains(mention1));
        assertTrue(mentionedUserNames.contains(mention2));
    }

    @Test
    public void testGetReplyRecipientShouldReturnEmptyOptionalIfNoReply() throws Exception {
        Tweet tweet = new Tweet();
        tweet.setMessage("some text sdfafsa");

        assertFalse(tweet.getReplyRecipient().isPresent());
    }

    @Test
    public void testAddRetweetShouldModifyRetweetCollection() throws Exception {
        Tweet tweet = new Tweet();
        Retweet retweet = new Retweet();
        tweet.addRetweet(retweet);

        assertThat(tweet.getRetweets().size(), is(1));
        assertTrue(tweet.getRetweets().contains(retweet));
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
}