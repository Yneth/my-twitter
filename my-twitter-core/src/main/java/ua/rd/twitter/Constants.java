package ua.rd.twitter;

import java.util.regex.Pattern;

public final class Constants {
    public static final String USERNAME_PREFIX = "@";

    public static final String USERNAME_REGEX = USERNAME_PREFIX + "\\w{1,15}";
    public static final Pattern USERNAME_PATTERN = Pattern.compile(Constants.USERNAME_REGEX);

    private Constants() {
    }
}
