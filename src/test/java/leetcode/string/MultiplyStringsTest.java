package leetcode.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyStringsTest {

    static final MultiplyStrings classUnderTest = new MultiplyStrings();

    @Test
    @DisplayName("Multiply test")
    void multiplyTest() {
        assertEquals("56088", classUnderTest.multiply("123", "456"));
        assertEquals("0", classUnderTest.multiply("1234567890", "0"));
        assertEquals("1524157875019052100", classUnderTest.multiply("1234567890", "1234567890"));
        assertEquals("72", classUnderTest.multiply("12", "6"));
    }

    @Test
    @DisplayName("Exception test")
    void multiplyExceptionTest() {
        assertThrows(NullPointerException.class, () -> classUnderTest.multiply(null, ""));
        assertThrows(IllegalArgumentException.class, () -> classUnderTest.multiply("", "  "));
    }
}