package algorithm.sort;

import java.util.Arrays;

import static algorithm.sort.SortUtil.*;

public class MergeSort {

    /**
     * @param length
     * @param <T>
     * @return
     */
    private static <T extends Comparable<T>> T[] getArray(int length) {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) new Comparable[length];
        return arr;
    }

    /**
     * Abstract in-place merge
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     * @param <T>
     */
    public static <T extends Comparable<T>> void merge(T[] a, int lo, int mid, int hi) {
        T[] aux = getArray(a.length); //auxiliary array for merges
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    /**
     * Top-Down mergesort
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    public static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // Sort left half.
        sort(a, mid + 1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results (code on page 271).
    }

    /**
     * Bottom-up mergesort
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<T>> void bottomUpSort(T[] a) {
        // Do lg N passes of pairwise merges.
        int N = a.length;
        for (int sz = 1; sz < N; sz = sz + sz)// sz: subarray size
            for (int lo = 0; lo < N - sz; lo += sz + sz) // lo: subarray index
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }

}
