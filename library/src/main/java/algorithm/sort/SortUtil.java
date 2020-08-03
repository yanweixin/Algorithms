package algorithm.sort;

public class SortUtil {
    /**
     * Returns if v is less than w
     *
     * @param v
     * @param w
     * @param <T>
     * @param <V>
     * @return
     */
    static <T extends Comparable<T>, V extends T> boolean less(T v, V w) {
        return v.compareTo(w) < 0;
    }

    /**
     * Exchange array entries at index i and j
     *
     * @param a
     * @param i
     * @param j
     */
    static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Print comparable array entries to standard output
     *
     * @param a
     */
    static <T extends Comparable<T>> void show(T[] a) {
        // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    /**
     * Test whether the array entries are in order.
     *
     * @param a
     * @return
     */
    static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
