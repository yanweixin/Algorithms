package algorithm.sort;

public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] arr, int low, int hi) {
        if (low < hi) {
            int partitionIndex = partition(arr, low, hi);
            sort(arr, low, partitionIndex - 1);
            sort(arr, partitionIndex + 1, hi);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int hi) {
        T pivot = arr[hi];
        int i = (low - 1);

        for (int j = low; j < hi; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;

                T swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        T swapTemp = arr[i + 1];
        arr[i + 1] = arr[hi];
        arr[hi] = swapTemp;

        return i + 1;
    }
}
