package algorithm.leetcode.tree;

import algorithm.leetcode.domain.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/">Merge Two Binary Trees</a>
 *
 * @author marvin
 * @version MergeTwoBinaryTree.java, v 0.1 2022/05/22 22:59 Exp $
 */
public class MergeTwoBinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

}