package ua.rd.twitter.service;

import ua.rd.twitter.domain.Reply;
import ua.rd.twitter.domain.Tweet;
import ua.rd.twitter.domain.UserProfile;

import java.util.List;

public interface UserProfileService {
    UserProfile findById(long userId);

    List<Tweet> getUserTimeLine(long userId);

    void follow(long followerId, long followeeId);

    void unfollow(long followerId, long followeeId);

    void notifyRecipient(Reply tweet);

    void notifyMentionedUsers(Tweet tweet);
}
