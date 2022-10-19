/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.topics.binarytree;

import algorithm.leetcode.domain.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/path-sum/">Path Sum</a>
 *
 * @author hufeng
 * @version $Id: PathSum.java, v 0.1 2018年07月12日 上午10:52 hufeng Exp $
 */
public class PathSum {


    /**
     * DFS
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return targetSum == root.val;
        else
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}