package algorithm.topics.dp;

/**
 * <a href="https://leetcode.cn/problems/jump-game>Jump Game</a>
 */
public class JumpGame {
    /**
     * 动态规划求解
     *
     * @param nums
     * @return
     */
    public static boolean canJumpByDp(int[] nums) {
        int len = nums.length;
        boolean[] f = new boolean[len];

        // init
        f[0] = true;
        // 转移方程 f[i] && j-i >= nums[i]
        for (int j = 1; j < len; j++) {
            // 先假设不能从i跳到j
            f[j] = false;
            // last jump is from i to j
            for (int i = 0; i < j; i++) {
                if (f[i] && i + nums[i] >= j) {
                    f[j] = true;
                    break;
                }
            }
        }
        return f[len - 1];
    }

    /**
     * 贪心算法求解： 不用考虑每一步跳跃到那个位置，而是尽可能的跳跃到最远的位置，看最多能覆盖的位置，不断更新能覆盖的距离。
     *
     * @param nums
     * @return
     */
    public static boolean canJumpByGreed(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = nums[0];
        for (int i = 0; i < cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJumpByDp(nums));
        System.out.println(canJumpByGreed(nums));
    }
}
