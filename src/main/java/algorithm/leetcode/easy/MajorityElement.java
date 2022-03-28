package algorithm.leetcode.easy;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {

    /**
     * 一般方法，通过Hash表来解
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            if (map.containsKey(ele)) {
                int cnt = map.get(ele);
                map.put(ele, ++cnt);
            } else {
                map.put(ele, 1);
            }
            if (map.get(ele) > len / 2) {
                return ele;
            }
        }
        return -1;
    }

    /**
     * Boyer-Moore 投票算法
     *
     * @param nums
     * @return
     */
    public static int majorityElementByBoyerMoore(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println(count);
        return candidate;
    }

    public static void main(String[] args) {
//        int r = majorityElementByBoyerMoore(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5});
        int r = majorityElementByBoyerMoore(new int[]{3,2});
        System.out.println(r);
    }
}
