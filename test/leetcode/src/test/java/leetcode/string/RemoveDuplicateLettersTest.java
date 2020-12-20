package leetcode.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicateLettersTest {
    static final RemoveDuplicateLetters classUnderTest = new RemoveDuplicateLetters();

    @Test
    void removeDuplicateLetters() {
        assertAll("Stack test",
                () -> assertEquals("abc", classUnderTest.useStack("abc")),
                () -> assertEquals("abc", classUnderTest.useStack("bcabc")),
                () -> assertEquals("acdb", classUnderTest.useStack("cbacdcbc")));
        assertAll("StringBuilder test",
                () -> assertEquals("abc", classUnderTest.useStringBuilder("abc")),
                () -> assertEquals("abc", classUnderTest.useStringBuilder("bcabc")),
                () -> assertEquals("acdb", classUnderTest.useStringBuilder("cbacdcbc")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"adajhdjf", "sdfggsef", "cdshcvdf", "aaaaa"})
    void uniqueTest(String s) {
        assertTrue(isUnique(classUnderTest.useStack(s)));
        assertTrue(isUnique(classUnderTest.useStringBuilder(s)));
    }

    @Test
    void isUniqueTest() {
        assertTrue(isUnique(""));
        assertTrue(isUnique("abc123"));
        assertTrue(isUnique(" _=+123,./[]"));
        assertFalse(isUnique("23r1u24"));
        assertFalse(isUnique("1996"));
    }

    private boolean isUnique(String str) {
        if (str.length() > 256) // Out of char boundary
            return false;
        boolean[] existed = new boolean[256];
        for (char ch : str.toCharArray()) {
            if (existed[ch])
                return false;
            existed[ch] = true;
        }
        return true;
    }
}