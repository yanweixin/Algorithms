package leetcode.string;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class RemoveDuplicateLettersBenchmark {
    private final RemoveDuplicateLetters benchmarkTest = new RemoveDuplicateLetters();

    @Param({"cdabc", "abcd", "blankblankcp"})
    public String s;

    @Benchmark
    public void baseLine() {
        // Left blank intentionally
    }

    @Benchmark
    public void stack() {
        benchmarkTest.useStack(s);
    }

    @Benchmark
    public void stringBuilder() {
        benchmarkTest.useStringBuilder(s);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RemoveDuplicateLettersBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
