package ua.rd.twitter.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public abstract class AbstractEntityTest<Id> {
    private AbstractEntity<Id> entity;

    protected abstract AbstractEntity<Id> create();

    @Before
    public void setUp() {
        entity = create();
    }

    @Test
    public void testIdShouldBeExcludedFromEquals() {
        AbstractEntity profile1 = withId(1L);
        AbstractEntity profile2 = withId(2L);

        assertTrue(profile1.equals(profile2));
    }

    @Test
    public void testIdShouldBeExcludedFromHashCode() {
        AbstractEntity profile1 = withId(1L);
        AbstractEntity profile2 = withId(2L);

        assertThat(profile1.hashCode(), is(profile2.hashCode()));
    }

    private AbstractEntity<Id> withId(Id id) {
        AbstractEntity<Id> abstractEntity = create();
        abstractEntity.setId(id);
        return abstractEntity;
    }
}
