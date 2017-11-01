package sun.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * Reference: <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">Construct Binary Tree from Preorder and Inorder Traversal</a>
 * <a href="http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder>Tree Traversals (Inorder, Preorder and Postorder)</a>
 *
 * @author hufeng
 * @version ConstructBinaryTreeFromPreAndInOrder.java, v 0.1 01/11/2017 3:30 PM Exp $
 */

public class ConstructBinaryTreeFromPreAndInOrder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(0, 0, inorder.length - 1, preorder, inorder);
    }


    private TreeNode buildSubTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode parent = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == parent.val) {
                inIndex = i;
            }
        }
        parent.left = buildSubTree(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        parent.right = buildSubTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return parent;
    }


    /**
     * <pre>
     *              1
     *            /   \
     *           2    3
     *          / \
     *         4   5
     * </pre>
     */
    @Test
    public void testNormalCase() {
        int[] preorder = new int[]{1, 2, 4, 5, 3};
        int[] inorder = new int[]{4, 2, 5, 1, 3};
        ConstructBinaryTreeFromPreAndInOrder c = new ConstructBinaryTreeFromPreAndInOrder();
        TreeNode tree = c.buildTree(preorder, inorder);
        assertNotNull(tree);
    }

    @Test
    public void testNormalCase2() {
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};
        ConstructBinaryTreeFromPreAndInOrder c = new ConstructBinaryTreeFromPreAndInOrder();
        TreeNode tree = c.buildTree(preorder, inorder);
        assertNotNull(tree);
    }

    @Test
    public void testNormalCase3() {
        int[] inorder = new int[]{1, 2, 3, 4};
        int[] preorder = new int[]{2, 1, 3, 4};
        ConstructBinaryTreeFromPreAndInOrder c = new ConstructBinaryTreeFromPreAndInOrder();
        TreeNode tree = c.buildTree(preorder, inorder);
        assertNotNull(tree);
    }

    @Test
    public void testNormalCase4() {
        int[] inorder = new int[]{1, 2, 3, 4, 5};
        int[] preorder = new int[]{1, 5, 2, 4, 3};
        ConstructBinaryTreeFromPreAndInOrder c = new ConstructBinaryTreeFromPreAndInOrder();
        TreeNode tree = c.buildTree(preorder, inorder);
        assertNotNull(tree);
    }

    @Test
    public void testBoundaryCondition() {
        int[] preorder = new int[]{1};
        int[] inorder = new int[]{1};
        ConstructBinaryTreeFromPreAndInOrder c = new ConstructBinaryTreeFromPreAndInOrder();
        TreeNode tree = c.buildTree(preorder, inorder);
        assertNotNull(tree);
    }

    @Test
    public void testBoundaryCondition2() {
        int[] preorder = new int[]{};
        int[] inorder = new int[]{};
        ConstructBinaryTreeFromPreAndInOrder c = new ConstructBinaryTreeFromPreAndInOrder();
        TreeNode tree = c.buildTree(preorder, inorder);
        assertNull(tree);
    }
}
