package algorithm.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static algorithm.search.BinarySearch.*;

class BinarySearchTest {

//    static final BinarySearch classUnderTest = new BinarySearch();

    @DisplayName("Rank test")
    @Test
    void rankTest() {
        assertAll(
                () -> assertEquals(-1, rank(5, new int[]{0, 1, 2, 3, 4})),
                () -> assertEquals(0, rank(1, new int[]{1, 2, 3, 4})),
                () -> assertEquals(1, rank(2, new int[]{1, 2, 3})),
                () -> assertEquals(1, rank(2, new int[]{1, 2, 3, 4}))
        );
    }
}