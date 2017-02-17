package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ua.rd.twitter.Constants;

import java.util.Optional;
import java.util.regex.Matcher;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"tweet",})
public class Reply extends Tweet {
    private Tweet tweet;

    private String recipient;

    public Optional<String> getRecipientUsername() {
        Matcher matcher = Constants.USERNAME_PATTERN.matcher(message);
        if (matcher.find() && matcher.start() == 0) {
            return Optional.of(matcher.group());
        }
        return Optional.empty();
    }
}
