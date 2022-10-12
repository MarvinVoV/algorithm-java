/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.topics.search;

/**
 * Reference <a href="https://leetcode.cn/problems/search-insert-position/">Search Insert Position</a>
 *
 * @author hufeng
 * @version $Id: SearchInsertPosition.java, v 0.1 2018年06月30日 下午7:48 hufeng Exp $
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        // Check tail
        if (target > nums[end])
            return end + 1;
        else if (target == nums[end])
            return end;

        // Check Header
        if (target <= nums[start])
            return start;

        int mid = (start + end) / 2;
        if (target <= nums[mid])
            return binarySearch(nums, target, start, mid);
        else
            return binarySearch(nums, target, mid + 1, end);
    }


    public int searchInsert2(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        } else if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }
        return nums.length;
    }

    public int searchInsert3(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}