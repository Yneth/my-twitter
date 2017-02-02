package ua.rd.twitter.domain;

public class UserProfileTest extends AbstractEntityTest {

    @Override
    protected AbstractEntity<Long> create() {
        return new UserProfile();
    }
}