package ua.rd.twitter.service;

import ua.rd.twitter.domain.Tweet;
import ua.rd.twitter.domain.UserProfile;

public interface UserProfileService {
    UserProfile findById(long userId);

    void notifyRecipient(Tweet tweet);

    void notifyMentionedUsers(Tweet tweet);
}
