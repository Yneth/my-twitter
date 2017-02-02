package ua.rd.twitter.service.exception;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(Long id) {
        super(id);
    }
}
