package ua.rd.twitter.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import ua.rd.twitter.domain.*;
import ua.rd.twitter.repository.TweetRepository;
import ua.rd.twitter.service.TweetService;
import ua.rd.twitter.service.UserProfileService;
import ua.rd.twitter.service.dto.CreateReplyDTO;
import ua.rd.twitter.service.dto.CreateRetweetDTO;
import ua.rd.twitter.service.dto.CreateTweetDTO;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TweetServiceImplTest {
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private TweetRepository tweetRepository;
    @Mock
    private UserProfileService userProfileService;

    private TweetService tweetService;

    @Before
    public void setUp() {
        tweetService = new TweetServiceImpl(modelMapper, tweetRepository, userProfileService);
    }

    @Test
    public void testAddReplyShouldNotifyRecipient() {
        when(userProfileService.findById(anyLong())).
                thenReturn(new UserProfile());

        tweetService.addReply(new CreateReplyDTO());

        verify(userProfileService).notifyRecipient(any(Reply.class));
    }

    @Test
    public void testAddReplyShouldNotifyMentionedUsers() {
        when(userProfileService.findById(anyLong())).
                thenReturn(new UserProfile());

        tweetService.addReply(new CreateReplyDTO());

        verify(userProfileService).notifyMentionedUsers(any(Reply.class));
    }

    @Test
    public void testAddRetweetShouldNotifyMentionedUsers() {
        when(userProfileService.findById(anyLong())).
                thenReturn(new UserProfile());

        tweetService.addRetweet(new CreateRetweetDTO());

        verify(userProfileService).notifyMentionedUsers(any(Retweet.class));
    }

    @Test
    public void testAddTweetShouldNotifyMentionedUsers() {
        when(userProfileService.findById(anyLong())).
                thenReturn(new UserProfile());

        tweetService.addTweet(new CreateTweetDTO());

        verify(userProfileService).notifyMentionedUsers(any(Tweet.class));
    }

    @Test
    public void testAddLikeToTweetShouldAddLike() {
        Tweet tweet = new Tweet();
        when(userProfileService.findById(anyLong())).
                thenReturn(new UserProfile());
        when(tweetRepository.findById(anyLong())).
                thenReturn(Optional.of(tweet));

        tweetService.addLikeToTweet(0, 0);

        assertTrue(!tweet.getLikes().isEmpty());
    }

    @Test
    public void testRemoveLikeFromTweetShouldRemoveLike() {
        Tweet tweet = new Tweet();
        UserProfile userProfile = new UserProfile();
        tweet.getLikes().add(new Like(userProfile, tweet));

        when(userProfileService.findById(anyLong())).
                thenReturn(new UserProfile());
        when(tweetRepository.findById(anyLong())).
                thenReturn(Optional.of(tweet));

        tweetService.removeLikeFromTweet(0, 0);

        assertTrue(tweet.getLikes().isEmpty());
    }
}