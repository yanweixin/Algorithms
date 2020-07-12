package algorithm.search;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static algorithm.search.BinarySearch.rank;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BinarySearchBenchmark {
    @Benchmark
    public void rankTest() {
        rank(12, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 12});
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BinarySearchBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
