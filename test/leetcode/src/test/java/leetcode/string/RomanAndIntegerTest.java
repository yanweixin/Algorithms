package leetcode.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class RomanAndIntegerTest {
    static final RomanAndInteger classUnderTest = new RomanAndInteger();

    @ParameterizedTest
    @CsvSource({"I,1", "III,3", "LVIII,58", "MCMXCIV,1994"})
    void romanToInt(String input, int result) {
        assertEquals(result, classUnderTest.romanToInt(input));
    }

    @ParameterizedTest
    @CsvSource({"1,I", "3,III", "58,LVIII", "1994,MCMXCIV"})
    void intToRoman(int input, String result) {
        assertEquals(result, classUnderTest.intToRoman(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> classUnderTest.romanToInt(input));
    }
}