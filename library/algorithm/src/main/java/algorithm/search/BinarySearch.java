package algorithm.search;

/**
 * <p>Provide some useful methods for binary searching</p>
 *
 * @since 0.0.1
 */
public class BinarySearch {

    /**
     * find the index of given value in a sorted array
     *
     * @param key value to find
     * @param a   a sorted array
     * @return return the index of found value , otherwise return -1
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
