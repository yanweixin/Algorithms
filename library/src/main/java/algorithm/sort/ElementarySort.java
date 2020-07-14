package algorithm.sort;

public final class ElementarySort extends Sort {

    /**
     * Use private constructor to avoid instantiating
     */
    private ElementarySort() {
        throw new AssertionError();
    }

    /**
     * <p>One of the simplest sorting algorithms works as follows:
     * First, find the smallest item in the array and exchange it with the first entry (itself if the first entry is already the smallest).
     * Then, find the next smallest item and exchange it with the second entry. Continue in this way until the entire array is sorted.
     * </p>
     *
     * @param a   the array to be sorted
     * @param <T>
     */
    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        // Sort a[] into increasing order.
        int N = a.length; // array length
        for (int i = 0; i < N; i++) {
            // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i; // index of minimal entr.
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    /**
     * <p>As in selection sort, the items to the left of the current index are in sorted order dur- ing the sort,
     * but they are not in their final position, as they may have to be moved to make room for smaller items encountered later.
     * The array is, however, fully sorted when the index reaches the right end.</p>
     *
     * <p>Unlike that of selection sort, the running time of insertion sort depends on the initial order of the items in the input.
     * For example, if the array is large and its entries are already in order (or nearly in order),
     * then insertion sort is much, much faster than if the entries are randomly ordered or in reverse order.</p>
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    /**
     * <p>Shellsort is a simple extension of insertion sort that gains speed by allowing exchanges of array entries
     * that are far apart, to produce partially sorted arrays that can be efficiently sorted, eventually by insertion sort.</p>
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<T>> void shellSort(T[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1) {
            // h-sort the array.
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = h / 3;
        }
    }

}
