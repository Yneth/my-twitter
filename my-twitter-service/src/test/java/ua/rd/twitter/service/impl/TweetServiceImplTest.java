package ua.rd.twitter.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.rd.twitter.domain.Tweet;
import ua.rd.twitter.domain.UserProfile;
import ua.rd.twitter.service.TweetService;
import ua.rd.twitter.service.UserProfileService;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TweetServiceImplTest {
    @Mock
    private UserProfileService userProfileService;

    private TweetService tweetService;

    @Before
    public void setUp() {
        tweetService = new TweetServiceImpl(userProfileService);
    }

    @Test
    public void testAddTweetShouldAddTweetForCurrentUser() {
        Tweet tweet = new Tweet();
        UserProfile profile = new UserProfile();

        when(userProfileService.findById(anyLong())).
                thenReturn(profile);

        tweetService.addTweet(1L, tweet);

        assertTrue(profile.getTweets().contains(tweet));
    }

    @Test
    public void testAddTweetShouldNotifyRecipient() {
        Tweet tweet = new Tweet();
        when(userProfileService.findById(anyLong())).
                thenReturn(new UserProfile());

        tweetService.addTweet(1L, tweet);

        verify(userProfileService).notifyRecipient(eq(tweet));
    }

    @Test
    public void testAddTweetShouldNotifyMentionedUsers() {
        Tweet tweet = new Tweet();
        when(userProfileService.findById(anyLong())).
                thenReturn(new UserProfile());

        tweetService.addTweet(1L, tweet);

        verify(userProfileService).notifyMentionedUsers(eq(tweet));
    }
}