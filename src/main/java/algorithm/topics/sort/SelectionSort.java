package algorithm.topics.sort;

import java.util.Arrays;

/**
 * @author hufeng
 * @version SelectionSort.java, v 0.1 2021/10/23 11:39 Exp $
 */

public class SelectionSort {
    public static void selectSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        for (int i = 0; i < a.length - 1; i++) {
            int minPos = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minPos]) {
                   minPos = j;
                }
            }
            swap(a, minPos, i);
        }
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 7, 4, 5, 2, 9};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
