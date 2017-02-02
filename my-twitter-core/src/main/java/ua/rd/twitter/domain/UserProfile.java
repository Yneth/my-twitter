package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false, exclude = {"tweets", "followers", "following"})
public class UserProfile extends AbstractEntity<Long> {
    private User account;

    private String firstName;

    private String lastName;

    private String langKey;

    private List<Tweet> replies = new ArrayList<>();

    private List<Tweet> mentions = new ArrayList<>();

    private List<Tweet> tweets = new ArrayList<>();

    private Set<UserProfile> followers = new HashSet<>();

    private Set<UserProfile> following = new HashSet<>();

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public void addFollower(UserProfile follower) {
        followers.add(follower);
    }

    public void addFollowee(UserProfile followee) {
        following.add(followee);
    }

    public void addMention(Tweet mention) {
        mentions.add(mention);
    }

    public void addAllMentions(List<Tweet> newMentions) {
        mentions.addAll(newMentions);
    }

    public void addReply(Tweet reply) {
        replies.add(reply);
    }
}
