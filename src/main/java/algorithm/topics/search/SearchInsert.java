package algorithm.topics.search;

/**
 * <a href="https://leetcode.cn/problems/N6YdxV>Search Insert</a>
 *
 * @author marvin
 * @version SearchInsert.java, v 0.1 2022/10/13 00:11 Exp $
 */
public class SearchInsert {
    /**
     * 问题转化为：在一个有序数组中找第一个大于等于  target 的下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
//            int mid = ((right - left) >> 1) + left;
            int mid = (left + right) >>> 1;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
