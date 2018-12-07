package sun.algorithm.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
 * Reference: <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/">Minimum Absolute Difference in BST</a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version MinimumAbsoluteDifferenceInBST.java, v 0.1 06/11/2017 12:42 AM Exp $
 */

public class MinimumAbsoluteDifferenceInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    static int min = Integer.MAX_VALUE;
    static Integer prev = null;

    /**
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


    private TreeNode root;

    @Before
    public void init() {
        root = new TreeNode(7);
        TreeNode a = new TreeNode(4);
        root.left = a;

        TreeNode b = new TreeNode(8);
        root.right = b;

        TreeNode c = new TreeNode(3);
        a.left = c;

    }


    @Test
    public void testNormalCase() {
        int result = getMinimumDifference(root);
        assertEquals(1, result);
    }
}
