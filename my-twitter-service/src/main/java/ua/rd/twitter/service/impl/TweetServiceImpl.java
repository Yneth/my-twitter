package ua.rd.twitter.service.impl;

import org.modelmapper.ModelMapper;
import ua.rd.twitter.domain.*;
import ua.rd.twitter.repository.TweetRepository;
import ua.rd.twitter.service.TweetService;
import ua.rd.twitter.service.UserProfileService;
import ua.rd.twitter.service.dto.CreateReplyDTO;
import ua.rd.twitter.service.dto.CreateRetweetDTO;
import ua.rd.twitter.service.dto.CreateTweetDTO;
import ua.rd.twitter.service.exception.TweetNotFoundException;

public class TweetServiceImpl implements TweetService {
    private final ModelMapper modelMapper;
    private final TweetRepository tweetRepository;
    private final UserProfileService userProfileService;

    public TweetServiceImpl(ModelMapper modelMapper,
                            TweetRepository tweetRepository,
                            UserProfileService userProfileService) {
        this.modelMapper = modelMapper;
        this.tweetRepository = tweetRepository;
        this.userProfileService = userProfileService;
    }

    @Override
    public Tweet findById(long tweetId) {
        return tweetRepository.findById(tweetId).
                orElseThrow(() -> new TweetNotFoundException(tweetId));
    }

    @Override
    public void addTweet(CreateTweetDTO tweetDTO) {
        save(tweetDTO, Tweet.class);
    }

    @Override
    public void addRetweet(CreateRetweetDTO retweetDTO) {
        save(retweetDTO, Retweet.class);
    }

    @Override
    public void addReply(CreateReplyDTO replyDTO) {
        Reply reply = save(replyDTO, Reply.class);
        userProfileService.notifyRecipient(reply);
    }

    private <T extends Tweet, D> T save(D dto, Class<T> type) {
        T tweet = modelMapper.map(dto, type);
        tweetRepository.saveTweet(tweet);
        userProfileService.notifyMentionedUsers(tweet);
        return tweet;
    }

    @Override
    public void addLikeToTweet(long tweetId, long userId) {
        Tweet tweet = findById(tweetId);
        UserProfile userProfile = userProfileService.findById(userId);

        Like like = new Like(userProfile, tweet);
        tweet.getLikes().add(like);
    }

    @Override
    public void removeLikeFromTweet(long tweetId, long userId) {
        Tweet tweet = findById(tweetId);
        UserProfile userProfile = userProfileService.findById(userId);

        Like like = new Like(userProfile, tweet);
        tweet.getLikes().remove(like);
    }
}
