package sun.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Reference: <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/description/">Minimum Depth of Binary Tree</a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version MinimumDepthOfBinaryTree.java, v 0.1 21/11/2017 12:25 AM Exp $
 */

public class MinimumDepthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        postOrderTraverse(root, 1, (root.left == null && root.right == null));
        return minDepth;
    }

    private void postOrderTraverse(TreeNode node, int depth, boolean isLeaf) {
        if (node == null) {
            return;
        }
        if (isLeaf) {
            minDepth = minDepth < depth ? minDepth : depth;
        }
        postOrderTraverse(node.left, depth + 1, (node.left != null && node.left.left == null && node.left.right == null));
        postOrderTraverse(node.right, depth + 1, (node.right != null && node.right.left == null && node.right.right == null));
    }

    // Good solution
    public int minDepthMethod2(TreeNode root) {
        if (root == null) return 0;
        int left = minDepthMethod2(root.left);
        int right = minDepthMethod2(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    @Test
    public void testNormalCase() {
        MinimumDepthOfBinaryTree t = new MinimumDepthOfBinaryTree();
        TreeNode root = new TreeNode(0);

        int minDepth = t.minDepth(root);
        assertEquals(1, minDepth);
    }
}
