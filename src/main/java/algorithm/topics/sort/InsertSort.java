package algorithm.topics.sort;

import java.util.Arrays;

/**
 * @author hufeng
 * @version InsertSort.java, v 0.1 2021/10/23 11:21 Exp $
 */

public class InsertSort {
    public static void insertSort(int[] a) {
        if (a.length == 1) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 6, 3, 2, 5, 9};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
