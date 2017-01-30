package ua.rd.twitter.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractEntityTest {
    protected abstract AbstractEntity<Long> create();

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

        assertEquals(profile1.hashCode(), profile2.hashCode());
    }

    private AbstractEntity<Long> withId(Long id) {
        AbstractEntity<Long> abstractEntity = create();
        abstractEntity.setId(id);
        return abstractEntity;
    }
}
