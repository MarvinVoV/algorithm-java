package algorithm.topics.binarytree;

import algorithm.leetcode.domain.TreeNode;

/**
 * Invert a binary tree.
 * <pre>
 *        4
 *      /   \
 *     2     7
 *    / \   / \
 *   1   3 6   9
 *
 * </pre>
 * to
 * <pre>
 *          4
 *        /   \
 *       7     2
 *      / \   / \
 *     9   6 3   1
 * </pre>
 * <p>
 * <p>
 * <a href="https://leetcode.cn/problems/invert-binary-tree/">Invert Binary Tree</a>
 * Difficulty: Easy
 * <p>
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * <pre>
 *     Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary
 *     tree on a whiteboard so fuck off.
 * </pre>
 *
 * @author hufeng
 * @version InvertBinaryTree.java, v 0.1 28/11/2017 10:17 PM Exp $
 */

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertBinaryTree(root);
        return root;
    }

    private static void invertBinaryTree(TreeNode node) {
        if (node == null) {
            return;
        }

        // swap left node and right node
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertBinaryTree(node.left);
        invertBinaryTree(node.right);
    }


}
