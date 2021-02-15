package algorithm.topics.sort;

/**
 * Created by sunyamorn on 4/12/16.
 */
public class BinarySearch {

    public static int binarySearch(int[] a, int v) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (high + low) >>> 1;
            if (a[mid] == v)
                return mid;
            else if (a[mid] < v)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return -(low + 1); // not found
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 8, 10, 34, 57, 35, 67};
        int v = 4;
        int result = BinarySearch.binarySearch(a, v);
        System.out.println(result);
        System.out.println(a[result]);
    }
}
