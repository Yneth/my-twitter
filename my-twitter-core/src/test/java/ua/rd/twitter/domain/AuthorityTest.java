package ua.rd.twitter.domain;

public class AuthorityTest extends AbstractEntityTest {

    @Override
    protected AbstractEntity<Long> create() {
        return new Authority();
    }
}