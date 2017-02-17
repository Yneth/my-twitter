package ua.rd.twitter.service;

import ua.rd.twitter.domain.Reply;
import ua.rd.twitter.domain.Retweet;
import ua.rd.twitter.domain.Tweet;

public interface TweetService {
    Tweet findById(long tweetId);

    void addTweet(long userId, Tweet tweet);

    void addReply(long userId, Reply reply);

    void addRetweet(long userId, Retweet retweet);

    void likeTweet(long tweetId, long userId);

    void unlikeTweet(long tweetId, long userId);
}
