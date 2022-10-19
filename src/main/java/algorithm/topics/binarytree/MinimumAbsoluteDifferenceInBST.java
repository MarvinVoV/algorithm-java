package algorithm.topics.binarytree;

import algorithm.leetcode.domain.TreeNode;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * Example:
 * <pre>
 *     Input:
 *     1
 *      \
 *       3
 *      /
 *     4
 *     Output:
 *     1
 *     Explanation:
 *     The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3)
 * </pre>
 * Note: There are at least two nodes in this BST.
 * <p>
 * Reference: <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/">Minimum Absolute Difference in BST</a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version MinimumAbsoluteDifferenceInBST.java, v 0.1 06/11/2017 12:42 AM Exp $
 */

public class MinimumAbsoluteDifferenceInBST {
    static int min = Integer.MAX_VALUE;
    static Integer prev = null;

    /**
     * 对于升序数组，求任意两个元素之差的绝对值的最小值，一定是相邻两个元素的最小值；
     * 二叉搜索树的性质： 二叉搜索树中序比那里得到的值序列是递增有序的；
     * The most common idea is to first inOrder traverse the tree and compare the delta between each of the adjacent values.
     * It's guaranteed to have the correct answer because it is a BST thus inOrder traversal values are sorted.
     *
     * @param root
     * @return
     */
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }


}
