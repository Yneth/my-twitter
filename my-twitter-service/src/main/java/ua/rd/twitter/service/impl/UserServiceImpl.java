package ua.rd.twitter.service.impl;

import ua.rd.twitter.domain.UserProfile;
import ua.rd.twitter.respository.UserProfileRepository;
import ua.rd.twitter.service.UserService;
import ua.rd.twitter.service.exception.UserNotFoundException;

public class UserServiceImpl implements UserService {
    private UserProfileRepository userProfileRepository;

    public UserServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile findById(Long id) {
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
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
}
