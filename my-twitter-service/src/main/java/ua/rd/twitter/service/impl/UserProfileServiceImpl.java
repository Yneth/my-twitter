package ua.rd.twitter.service.impl;

import ua.rd.twitter.domain.Tweet;
import ua.rd.twitter.domain.UserProfile;
import ua.rd.twitter.respository.UserProfileRepository;
import ua.rd.twitter.service.UserProfileService;
import ua.rd.twitter.service.exception.UserNotFoundException;

import java.util.List;

public class UserProfileServiceImpl implements UserProfileService {
    private UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile findById(long id) {
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public List<Tweet> getUserTweets(long userId) {
        return null;
    }

    @Override
    public void follow(long followerId, long followeeId) {
        if (followeeId == followerId) {
            return;
        }

        UserProfile follower = findById(followerId);
        UserProfile followee = findById(followeeId);

        follower.getFollowing().add(followee);
        followee.getFollowers().add(follower);
    }

    @Override
    public void unfollow(long followerId, long followeeId) {
        if (followeeId == followerId) {
            return;
        }

        UserProfile follower = findById(followerId);
        UserProfile followee = findById(followeeId);

        follower.getFollowing().remove(followee);
        followee.getFollowers().remove(follower);
    }

    @Override
    public void notifyRecipient(Tweet tweet) {

    }

    @Override
    public void notifyMentionedUsers(Tweet tweet) {

    }
}
