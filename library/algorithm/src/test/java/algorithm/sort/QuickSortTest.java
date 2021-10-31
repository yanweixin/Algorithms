package algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class QuickSortTest {
    AtomicInteger incr = new AtomicInteger();

    @Test
    void sort() {
        Integer[] arr = {1, 2, 3, 8, 7, 6};
        QuickSort.sort(arr, 0, arr.length - 1);
        int[] ints = new Random().ints(10, 0, 10).toArray();
        quickSort1(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    private void quickSort1(int[] arr, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = arr[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (arr[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (arr[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = key;
        quickSort1(arr, left, i - 1);
        quickSort1(arr, i + 1, right);
    }

    private void quickSort2(int[] arr, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = arr[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (arr[j] >= key && i < j) {
                j--;
            }
            arr[i] = arr[j];
            //i向右移，直到遇到比key大的值
            while (arr[i] <= key && i < j) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = key;
        quickSort2(arr, left, i - 1);
        quickSort2(arr, i + 1, right);
    }
}