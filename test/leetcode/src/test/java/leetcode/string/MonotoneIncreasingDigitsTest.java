package leetcode.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MonotoneIncreasingDigitsTest {
    static final MonotoneIncreasingDigits classUnderTest = new MonotoneIncreasingDigits();

    @Test
    void monotoneIncreasingDigits() {
        assertAll("Manually selected inputs",
                () -> assertEquals(299, classUnderTest.monotoneIncreasingDigits(332)),
                () -> assertEquals(9, classUnderTest.monotoneIncreasingDigits(10)));
    }

    @DisplayName("Equal test")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 9, 12, 99, 123, 1234, 1567, 9999})
    void equalTest(int N) {
        assertEquals(N, classUnderTest.monotoneIncreasingDigits(N),
                "For monotone increasing digits input ,result should be the same");
    }

    @DisplayName("Random test")
    @ParameterizedTest
    @MethodSource("randomIntsProvider")
    void randomTest(int randomN) {
        var result = classUnderTest.monotoneIncreasingDigits(randomN);
        assertTrue(randomN >= result, "Result must be less than or equal to input");
        assertTrue(isIncreasing(result), "Result must be increasing digits");
    }

    private static IntStream randomIntsProvider() {
        return new Random().ints(5, 0, (int) Math.pow(10, 9) + 1);
    }

    private boolean isIncreasing(int N) {
        final char[] digits = String.valueOf(N).toCharArray();
        final int length = digits.length;
        for (int i = 0; i < length - 1; i++) {
            if (digits[i] > digits[i + 1]) {
                return false;
            }
        }
        return true;
    }
}