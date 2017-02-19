package ua.rd.twitter.repository.impl;

import ua.rd.twitter.domain.Tweet;
import ua.rd.twitter.repository.TweetRepository;

import java.util.Optional;

public class JpaTweetRepository implements TweetRepository {

    @Override
    public Optional<Tweet> findById(long tweetId) {
        return null;
    }

    @Override
    public void saveTweet(Tweet tweet) {

    }
}
