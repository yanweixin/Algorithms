package algorithm.search;

import org.openjdk.jmh.annotations.Benchmark;

public class BinarySearchBenchmark {
    @Benchmark
    public void rank() {
        BinarySearch.rank(12, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 12});
    }
}
