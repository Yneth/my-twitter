package ua.rd.twitter.service.exception;

public class TweetNotFoundException extends EntityNotFoundException {

    public TweetNotFoundException(Long id) {
        super(id);
    }
}
