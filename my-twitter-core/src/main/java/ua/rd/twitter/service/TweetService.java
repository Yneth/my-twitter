package ua.rd.twitter.service;

import ua.rd.twitter.domain.Tweet;

public interface TweetService {
    void addTweet(long userId, Tweet tweet);
}
