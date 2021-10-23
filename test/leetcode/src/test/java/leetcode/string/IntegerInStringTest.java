package leetcode.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class IntegerInStringTest {
    final static IntegerInString classUnitTest = new IntegerInString();

    @ParameterizedTest
    @NullAndEmptySource
    void blankTest(String input) {
        assertEquals(0, classUnitTest.myAtoi(input));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "+42,42", "+-42,0", "4193 with words,4193", "words and 987,0", "-91283472332,-2147483648"})
    void multiTest(String input, int result) {
        assertEquals(result, classUnitTest.myAtoi(input));
    }

    @Test
    void test() {
        assertEquals(-42, classUnitTest.myAtoi("   -42"));
        assertEquals(1, classUnitTest.myAtoi("1"));
        assertEquals(1, classUnitTest.myAtoi(" +1"));
        assertEquals(0, classUnitTest.myAtoi(" "));
    }

}