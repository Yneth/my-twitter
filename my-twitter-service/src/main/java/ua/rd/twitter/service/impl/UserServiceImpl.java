package ua.rd.twitter.service.impl;

import ua.rd.twitter.domain.UserProfile;
import ua.rd.twitter.domain.exception.AlreadyFollowingException;
import ua.rd.twitter.domain.exception.SelfFollowException;
import ua.rd.twitter.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void follow(UserProfile follower, UserProfile followee) {
        if (follower.getId().equals(followee.getId())) {
            throw new SelfFollowException();
        }
        if (follower.getFollowing().contains(followee)) {
            throw new AlreadyFollowingException(follower.getId(), followee.getId());
        }
        follower.addFollowee(followee);
        followee.addFollower(follower);
    }

    public void unfollow(UserProfile follower, UserProfile followee) {

    }
}
