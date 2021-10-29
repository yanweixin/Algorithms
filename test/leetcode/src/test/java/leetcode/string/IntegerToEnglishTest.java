package leetcode.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToEnglishTest {
    static final IntegerToEnglish classUnderTest = new IntegerToEnglish();

    @ParameterizedTest
    @CsvSource({"0,Zero", "1,One", "123,One Hundred Twenty Three", "12345,Twelve Thousand Three Hundred Forty Five",
            "1234567,One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
            "1234567891,One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"})
    void numberToWords(int number, String output) {
        assertEquals(output, classUnderTest.numberToWords(number));
    }
}