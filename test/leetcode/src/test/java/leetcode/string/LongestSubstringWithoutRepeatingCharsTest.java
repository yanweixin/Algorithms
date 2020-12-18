package leetcode.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharsTest {
    static final LongestSubstringWithoutRepeatingChars classUnderTest = new LongestSubstringWithoutRepeatingChars();

    @Test
    void lengthOfLongestSubstringTest() {
        assertEquals(3, classUnderTest.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, classUnderTest.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, classUnderTest.lengthOfLongestSubstring("pwwkew"));
        assertEquals(10, classUnderTest.lengthOfLongestSubstring("121234567890"));
    }
}