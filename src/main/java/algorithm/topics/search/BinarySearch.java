package algorithm.topics.search;

/**
 * Created by sunyamorn on 4/12/16.
 */
public class BinarySearch {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    /**
     * 非递归方式
     *
     * @param a
     * @param v
     * @return
     */
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

    /**
     * 递归方式二分法搜索
     *
     * @param a
     * @param start
     * @param end
     * @param v     目标值
     * @return
     */
    public static int binarySearchByRecursive(int[] a, int start, int end, int v) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int mid = (start + end) >>> 1;
//        int mid = start + (end -start ) / 2 ;
        if (a[mid] == v) {
            return mid;
        }
        return v > a[mid] ? binarySearchByRecursive(a, mid + 1, end, v) :
                binarySearchByRecursive(a, start, mid - 1, v);
    }


    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 8, 10, 34, 57, 35, 67};
        int v = 4;
        int result = BinarySearch.binarySearch(a, v);
        System.out.println(result);
        result = BinarySearch.binarySearchByRecursive(a, 0, a.length - 1, v);
        System.out.println(result);

        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
    }
}
