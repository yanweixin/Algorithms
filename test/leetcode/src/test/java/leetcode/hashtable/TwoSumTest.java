package leetcode.hashtable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoSumTest {
    static final TwoSum classUnderTest = new TwoSum();

    @DisplayName("Single test")
    @Test
    void twoSumSingleTest() {
        assertArrayEquals(new int[]{0, 1}, classUnderTest.twoSum(new int[]{0, 1}, 1));
    }

    @DisplayName("Test method without exception")
    @ParameterizedTest
    @MethodSource("inputAndResultProvider")
    void twoSumTest(int[] nums, int target, int[] result) {
        assertArrayEquals(classUnderTest.twoSum(nums, target), result);
    }

    static Stream<Arguments> inputAndResultProvider() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 5}, 9, new int[]{0, 1}),
                arguments(new int[]{1, 3, 8, 6, 7}, 8, new int[]{0, 4})
        );
    }

    @DisplayName("Test method if no solution found")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 4})
    void twoSumExceptionTest(int target) {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> classUnderTest.twoSum(new int[]{1, 2, 7, 8, 9}, target));
        assertEquals("No two sum solution", exception.getMessage(),
                "Method should return specific message");
    }

}