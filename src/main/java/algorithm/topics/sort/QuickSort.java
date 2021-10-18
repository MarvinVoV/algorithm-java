package algorithm.topics.sort;

import java.util.Arrays;

/**
 * Created by sunyamorn on 4/12/16.
 */
public class QuickSort {
    public static void quickSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int k = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = k;
        }
    }

    public static void quickSortV2(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            // Before pi
            quickSortV2(a, low, pi - 1);
            // After pi
            quickSortV2(a, pi + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivot) --high;
            a[low] = a[high];
            while (low < high && a[low] < pivot) ++low;
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 8, 4, 3, 6, 7};
        quickSortV2(a, 0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
