package ua.rd.twitter.repository.impl;

import ua.rd.twitter.domain.UserProfile;
import ua.rd.twitter.respository.UserProfileRepository;

import java.util.Optional;

public class JpaUserProfileRepository implements UserProfileRepository {

    @Override
    public Optional<UserProfile> findById(Long id) {
        return null;
    }
}
