/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/path-sum/description/">Path Sum</a>
 *
 * @author hufeng
 * @version $Id: PathSum.java, v 0.1 2018年07月12日 上午10:52 hufeng Exp $
 */
public class PathSum {

    class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return sum == root.val;
        else
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


}