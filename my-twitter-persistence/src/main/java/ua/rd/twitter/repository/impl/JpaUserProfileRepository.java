package ua.rd.twitter.repository.impl;

import ua.rd.twitter.domain.UserProfile;
import ua.rd.twitter.repository.UserProfileRepository;

import java.util.List;
import java.util.Optional;

public class JpaUserProfileRepository implements UserProfileRepository {

    @Override
    public Optional<UserProfile> findById(Long id) {
        return null;
    }

    @Override
    public List<UserProfile> findByUsernames(List<String> usernames) {
        return null;
    }
}
