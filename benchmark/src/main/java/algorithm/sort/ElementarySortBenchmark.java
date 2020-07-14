package algorithm.sort;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static algorithm.sort.ElementarySort.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Group)
public class ElementarySortBenchmark<T extends Comparable<T>, V extends T> {

    private static final Random random = new Random();

    @Param({"128", "256", "512", "1024"})
    public int size;

    public Integer[] a;

    @Setup
    public void prepare() {
        a = new Integer[size];
        List<Integer> list = random.ints().limit(size).boxed().collect(Collectors.toList());
        list.toArray(a);
    }

    @TearDown
    public void reset() {
        try (BufferedWriter br =
                     new BufferedWriter(new FileWriter("build/tmp/ElementarySortBenchmark.txt", true))) {
            br.write(Arrays.asList(a).toString());
            br.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    @Group("Baseline")
    public void baseline() {
        // do nothing, this is a baseline
    }

    @Benchmark
    @Group("Selection")
    public void selectionSortSingle() {
        selectionSort(a);
    }

    @Benchmark
    @Group("Insertion")
    public void insertionSortSingle() {
        insertionSort(a);
    }

    @Benchmark
    @Group("Shell")
    public void shellSortSingle() {
        shellSort(a);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ElementarySortBenchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
