package ua.rd.twitter.service;

import ua.rd.twitter.domain.UserProfile;

public interface UserService {
    UserProfile findById(Long id);

    void follow(long followerId, long followeeId);

    void unfollow(long followerId, long followeeId);
}
