package leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class HashTableTest {

    val classUnderTest = HashTable()

    @Nested
    inner class TwoSum {
        @DisplayName("two sum test")
        @Test
        fun twoSumTest() {
            assertArrayEquals(intArrayOf(0, 1), classUnderTest.twoSum(intArrayOf(2, 7, 11, 5), 9))
            assertThrows<IllegalArgumentException> { classUnderTest.twoSum(intArrayOf(0), 9) }
        }
    }

}