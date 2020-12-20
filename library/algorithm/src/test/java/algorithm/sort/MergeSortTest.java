package algorithm.sort;


import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static algorithm.sort.MergeSort.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MergeSortTest {
    private final List<List<Integer>> integers = new ArrayList<>();

    @ParameterizedTest
    @MethodSource("intsProvider")
    void sortTest(List<Integer> ints) {
        var array = ints.toArray(Integer[]::new);
        sort(array);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @ParameterizedTest
    @MethodSource("intsProvider")
    void bottomUpSortTest(List<Integer> ints) {
        var array = ints.toArray(Integer[]::new);
        bottomUpSort(array);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    private Stream<List<Integer>> intsProvider() {
        permute(java.util.Arrays.asList(3, 2, 1), 0);
        return integers.stream();
    }

    private void permute(List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            java.util.Collections.swap(arr, i, k);
            permute(arr, k + 1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size()) {
            integers.add(arr);
        }
    }
}