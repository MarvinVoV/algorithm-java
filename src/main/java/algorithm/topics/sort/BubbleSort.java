package algorithm.topics.sort;

import java.util.Arrays;

/**
 * @author hufeng
 * @version BubbleSort.java, v 0.1 2021/10/23 10:41 Exp $
 */

public class BubbleSort {
    public static void bubbleSort(int[] a) {
        if (a.length == 1) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            // 提前退出冒泡循环的标志
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) break;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 6, 1, 2, 9, 4};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
