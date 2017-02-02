package ua.rd.twitter.service;

import ua.rd.twitter.domain.UserProfile;

public interface UserService {
    void follow(UserProfile follower, UserProfile followee);
}
