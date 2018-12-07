package sun.algorithm.leetcode.easy;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

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
 * <a href="https://leetcode.com/problems/invert-binary-tree/description/">Invert Binary Tree</a>
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
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertBinaryTree(root);
        return root;
    }

    private void invertBinaryTree(TreeNode node) {
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


    @Test
    public void testNormalCase() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        TreeNode res = invertTree(root);
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void testComplexCase() {
        TreeNode root = new TreeNode(4);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(7);
        root.left = l;
        root.right = r;
        l.left = new TreeNode(1);
        l.right = new TreeNode(3);
        r.left = new TreeNode(6);
        r.right = new TreeNode(9);

        TreeNode res = invertTree(root);
        System.out.println(JSON.toJSONString(res));

    }

    @Test
    public void testNullCase() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        root.left = left;
        TreeNode res = invertTree(root);
        System.out.println(JSON.toJSONString(res));
    }
}
