package leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    static final ReverseInteger classUnderTest = new ReverseInteger();

    @Test
    void reverseIntegerTest() {
        assertEquals(0, classUnderTest.reverse(0));
        assertEquals(0, classUnderTest.reverse(2147483647));
        assertEquals(2111111111, classUnderTest.reverse(1111111112));
        assertEquals(-1, classUnderTest.reverse(-1));
        assertEquals(-1, classUnderTest.reverse(-10));
        assertEquals(0, classUnderTest.reverse(-2147483648));
        assertEquals(-2111111111, classUnderTest.reverse(-1111111112));
    }

}