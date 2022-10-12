package algorithm.topics.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/two-sum/">Two Sum</a>
 *
 * @author hufeng
 * @version TwoSum.java, v 0.1 2021/10/17 21:37 Exp $
 */

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dict.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (dict.containsKey(key) && i != dict.get(key)) {
                result[0] = i;
                result[1] = dict.get(key);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
        int[] nums = new int[]{3,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
