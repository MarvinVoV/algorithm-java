package algorithm.leetcode.easy;

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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(0, 0, inorder.length - 1, preorder, inorder);
    }


    private static TreeNode buildSubTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
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


}
