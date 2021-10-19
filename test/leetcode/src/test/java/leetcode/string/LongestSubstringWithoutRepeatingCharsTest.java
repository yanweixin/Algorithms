package leetcode.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharsTest {
    static final LongestSubstringWithoutRepeatingChars classUnderTest = new LongestSubstringWithoutRepeatingChars();

    @ParameterizedTest
    @CsvSource(textBlock = """
               3,abcabcbb
               1,bbbbb
               3,pwwkew
               10,121234567890
            """)
    void lengthOfLongestSubstringTest(int expected, String str) {
        assertEquals(expected, classUnderTest.lengthOfLongestSubstring(str));
    }

    @ParameterizedTest
    @EmptySource
    void emptyTest(String input) {
        assertEquals(0, classUnderTest.lengthOfLongestSubstring(input));
    }

    @ParameterizedTest
    @NullSource
    void nullTest(String input) {
        assertThrows(NullPointerException.class, () -> classUnderTest.lengthOfLongestSubstring(input));
    }
}