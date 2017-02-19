package ua.rd.twitter.repository;

import ua.rd.twitter.domain.Tweet;

import java.util.Optional;

public interface TweetRepository {
    Optional<Tweet> findById(long tweetId);

    void saveTweet(Tweet tweet);
}
