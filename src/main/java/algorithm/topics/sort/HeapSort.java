package algorithm.topics.sort;

import java.util.Arrays;

/**
 * @author hufeng
 * @version HeapSort.java, v 0.1 2021/11/22 16:33 Exp $
 */

public class HeapSort {
    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapfiy(a, n, i);
        }
    }

    private static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapfiy(a, k, 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 6, 3, 2};
        sort(a, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void heapfiy(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
