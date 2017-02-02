package ua.rd.twitter.service;

import ua.rd.twitter.domain.Tweet;
import ua.rd.twitter.domain.UserProfile;

public interface UserProfileService {
    UserProfile findById(Long userId);

    void notifyRecipient(Tweet tweet);

    void addMentionsFor(Tweet tweet);
}
