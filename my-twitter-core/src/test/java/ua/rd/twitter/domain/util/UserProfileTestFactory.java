package ua.rd.twitter.domain.util;

import ua.rd.twitter.domain.UserProfile;

public final class UserProfileTestFactory {

    private UserProfileTestFactory() {
    }

    public static UserProfile withId(Long id) {
        UserProfile profile = new UserProfile();
        profile.setId(id);
        return profile;
    }
}
