package algorithm.leetcode.easy;

/**
 * @author hufeng
 * @version MySqrt.java, v 0.1 2021/11/4 22:53 Exp $
 */

public class MySqrt {
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MySqrt sqrt = new MySqrt();
//        for (int i = 1; i <= 100; i++) {
//            System.out.println(i + "---"+ sqrt.mySqrt(i));
//        }
        System.out.println(sqrt.mySqrt(2147395599));

    }
}
