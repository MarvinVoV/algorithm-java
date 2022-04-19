package algorithm.topics.dp;

/**
 * @author marvin
 * @version LargestSumContiguousSubArray.java, v 0.1 2022/04/19 09:18 Exp $
 */
public class LargestSumContiguousSubArray {
    /**
     * 动态规划求解
     *
     * @param nums
     * @return
     */
    public static int maxSubArraySum(int[] nums) {
        int currentMax = nums[0];
        int maxOfAll = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxOfAll = Math.max(maxOfAll, currentMax);
        }
        return maxOfAll;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(nums));
    }

}
