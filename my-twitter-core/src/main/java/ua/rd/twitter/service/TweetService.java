package ua.rd.twitter.service;

import ua.rd.twitter.domain.Tweet;
import ua.rd.twitter.service.dto.CreateReplyDTO;
import ua.rd.twitter.service.dto.CreateRetweetDTO;
import ua.rd.twitter.service.dto.CreateTweetDTO;

public interface TweetService {
    Tweet findById(long tweetId);

    void addTweet(CreateTweetDTO tweetDTO);

    void addRetweet(CreateRetweetDTO retweetDTO);

    void addReply(CreateReplyDTO replyDTO);

    void addLikeToTweet(long tweetId, long userId);

    void removeLikeFromTweet(long tweetId, long userId);
}
