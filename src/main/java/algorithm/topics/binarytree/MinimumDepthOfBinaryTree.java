package algorithm.topics.binarytree;

import algorithm.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Reference: <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">Minimum Depth of Binary Tree</a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version MinimumDepthOfBinaryTree.java, v 0.1 21/11/2017 12:25 AM Exp $
 */

public class MinimumDepthOfBinaryTree {

    static int minDepth = Integer.MAX_VALUE;

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        postOrderTraverse(root, 1, (root.left == null && root.right == null));
        return minDepth;
    }

    private static void postOrderTraverse(TreeNode node, int depth, boolean isLeaf) {
        if (node == null) {
            return;
        }
        if (isLeaf) {
            minDepth = Math.min(minDepth, depth);
        }
        postOrderTraverse(node.left, depth + 1, (node.left != null && node.left.left == null && node.left.right == null));
        postOrderTraverse(node.right, depth + 1, (node.right != null && node.right.left == null && node.right.right == null));
    }

    // Good solution

    /**
     * 深度优先搜索  DSF
     *
     * @param root
     * @return
     */
    public static int minDepthMethod2(TreeNode root) {
        if (root == null) return 0;
        int left = minDepthMethod2(root.left);
        int right = minDepthMethod2(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * 广度优先搜索 BSF
     *
     * @param root
     * @return
     */
    public int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }


}
