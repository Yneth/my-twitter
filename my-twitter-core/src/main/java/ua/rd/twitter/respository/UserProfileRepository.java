package ua.rd.twitter.respository;

import ua.rd.twitter.domain.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepository {
    Optional<UserProfile> findById(Long id);

    List<UserProfile> findByUsernames(List<String> usernames);
}
