package ua.rd.twitter.domain;

public class UserTest extends AbstractEntityTest {

    @Override
    protected AbstractEntity<Long> create() {
        return new User();
    }
}