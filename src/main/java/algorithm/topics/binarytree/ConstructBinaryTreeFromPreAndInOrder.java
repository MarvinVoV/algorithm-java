package algorithm.topics.binarytree;

import algorithm.leetcode.domain.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * Reference: <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct Binary Tree from Preorder and Inorder Traversal</a>
 * <a href="http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder>Tree Traversals (Inorder, Preorder and Postorder)</a>
 *
 * @author hufeng
 * @version ConstructBinaryTreeFromPreAndInOrder.java, v 0.1 01/11/2017 3:30 PM Exp $
 */

public class ConstructBinaryTreeFromPreAndInOrder {


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(0, 0, inorder.length - 1, preorder, inorder);
    }


    private static TreeNode buildSubTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        // 前序遍历的第一个节点就是根节点
        TreeNode parent = new TreeNode(preorder[preStart]);
        // 在中序遍历中定位根节点, 其左侧为左子树节点，右侧为右子树节点
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == parent.val) {
                inIndex = i;
            }
        }
        // 递归的构造左子树
        parent.left = buildSubTree(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // 递归的构造右子树
        parent.right = buildSubTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return parent;
    }


}
