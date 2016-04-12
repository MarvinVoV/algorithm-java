package sun.algorithm.sort;

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

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 8, 4 ,3, 6, 7};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
