package algorithm.sort;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static algorithm.sort.Sort.*;
import static org.junit.jupiter.api.Assertions.*;

class SortTest<T extends Comparable<T>, V extends T> {

    @Nested
    @DisplayName("less() method test")
    class LessTest {
        @ParameterizedTest
        @CsvSource({
                "1, 2", "0.9, 1", "2.3f, 3.0"
        })
        void lessTrueTest(T v, V w) {
            assertTrue(less(v, w));
        }

        @ParameterizedTest
        @CsvSource({
                "1, 1", "b, a"
        })
        void lessFalseTest(T v, V w) {
            assertFalse(less(v, w));
        }
    }

    @Test
    @DisplayName("Exchange value test")
    void exchTest() {
        Integer[] integers = new Integer[]{1, 3, 2, 4};
        exch(integers, 1, 2);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, integers);
        exch(integers, 0, 3);
        assertArrayEquals(new Integer[]{4, 2, 3, 1}, integers);
        exch(integers, 1, 2);
        assertArrayEquals(new Integer[]{4, 3, 2, 1}, integers);
    }

    @Nested
    @DisplayName("show() method test")
    class ShowTest {
        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final PrintStream originalOut = System.out;

        @BeforeEach
        public void setUpStreams() {
            System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        public void restoreStreams() {
            System.setOut(originalOut);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4", "1.1,2,3,4", "web,is,dead"})
        void showTest(@ConvertWith(StringArrayConverter.class) T[] a) {
            show(a);
            assertEquals(Stream.of(a).map(String::valueOf).collect(Collectors.joining(" ")) + " \n",
                    outContent.toString());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "1.1,2,3,4", "abc,abcd,abd"})
    void isSortedTest(@ConvertWith(StringArrayConverter.class) T[] a) {
        assertTrue(isSorted(a));
    }

    static class StringArrayConverter extends SimpleArgumentConverter {
        @Override
        public Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            if (source instanceof String && targetType.isAssignableFrom(String[].class)) {
                return ((String) source).split(",");
            } else {
                throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                        + targetType + " not supported.");
            }
        }
    }
}