package ua.rd.twitter.service.impl;

import ua.rd.twitter.domain.Reply;
import ua.rd.twitter.domain.Retweet;
import ua.rd.twitter.domain.Tweet;
import ua.rd.twitter.domain.UserProfile;
import ua.rd.twitter.respository.TweetRepository;
import ua.rd.twitter.service.TweetService;
import ua.rd.twitter.service.UserProfileService;

public class TweetServiceImpl implements TweetService {
    private TweetRepository tweetRepository;
    private UserProfileService userProfileService;

    public TweetServiceImpl(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Override
    public Tweet findById(long tweetId) {
        return tweetRepository.findById(tweetId).
                orElseThrow(() -> new TweetNotFoundException());
    }

    @Override
    public void addTweet(long userId, Tweet tweet) {
        tweetRepository.saveTweet(tweet);
        userProfileService.notifyMentionedUsers(tweet);
    }

    @Override
    public void addReply(long userId, Reply reply) {
        tweetRepository.saveTweet(reply);
    }

    @Override
    public void addRetweet(long userId, Retweet retweet) {
        doAddTweet(userId, retweet);
    }

    @Override
    public void likeTweet(long tweetId, long userId) {

    }

    @Override
    public void unlikeTweet(long tweetId, long userId) {

    }
}
