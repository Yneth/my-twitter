package ua.rd.twitter.domain;

import org.junit.Test;
import ua.rd.twitter.Constants;

import java.util.regex.Matcher;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReplyMentionRegexTest {

    @Test
    public void testShouldMatchOneCharacterAfterAt() {
        String input = "@a";
        Matcher matcher = Constants.USERNAME_PATTERN.matcher(input);

        assertTrue(matcher.matches());
    }

    @Test
    public void testShouldMatchOneDigitAfterAt() {
        String input = "@1";
        Matcher matcher = Constants.USERNAME_PATTERN.matcher(input);

        assertTrue(matcher.matches());
    }

    @Test
    public void testShouldNotMatchZeroSymbolsAfterAt() {
        String input = "@";
        Matcher matcher = Constants.USERNAME_PATTERN.matcher(input);

        assertFalse(matcher.matches());
    }

    @Test
    public void testShouldNotMatchSixteenDigitsAfterAt() {
        String input = "@1234567890123456";
        Matcher matcher = Constants.USERNAME_PATTERN.matcher(input);

        assertFalse(matcher.matches());
    }

    @Test
    public void testShouldMatchFifteenDigitsAfterAt() {
        String input = "@123456789012345";
        Matcher matcher = Constants.USERNAME_PATTERN.matcher(input);

        assertTrue(matcher.matches());
    }

    @Test
    public void testShouldMatchFifteenCharactersAfterAt() {
        String input = "@qwertyuiopsdfgh";
        Matcher matcher = Constants.USERNAME_PATTERN.matcher(input);

        assertTrue(matcher.matches());
    }

    @Test
    public void testShouldMatchFifteenUnderscoresAfterAt() {
        String input = "@_______________";
        Matcher matcher = Constants.USERNAME_PATTERN.matcher(input);

        assertTrue(matcher.matches());
    }
}
