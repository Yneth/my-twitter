package ua.rd.twitter.service.impl;

import ua.rd.twitter.domain.Tweet;
import ua.rd.twitter.domain.UserProfile;
import ua.rd.twitter.service.TweetService;
import ua.rd.twitter.service.UserProfileService;

public class TweetServiceImpl implements TweetService {
    private UserProfileService userProfileService;

    @Override
    public void addTweet(Long userId, Tweet tweet) {
        UserProfile profile = userProfileService.findById(userId);

        profile.getTweets().add(tweet);

        userProfileService.notifyRecipient(tweet);
        userProfileService.addMentionsFor(tweet);
    }
}
