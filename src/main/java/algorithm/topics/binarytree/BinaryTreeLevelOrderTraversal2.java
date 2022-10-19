package algorithm.topics.binarytree;

import algorithm.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <pre>
 *         3
 *        / \
 *       9  20
 *         /  \
 *        15   7
 * </pre>
 * return its bottom-up level order traversal as:
 * <pre>
 *     [
 *          [15,7],
 *          [9,20],
 *          [3]
 *      ]
 * </pre>
 * <p>
 * Reference: <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/">Binary Tree Level Order Traversal II</a>
 *
 * @author hufeng
 * @version BinaryTreeLevelOrderTraversal2.java, v 0.1 10/11/2017 7:47 PM Exp $
 */

public class BinaryTreeLevelOrderTraversal2 {

    /**
     * Binary Tree Level Order Iterator. But think of all nodes of the same layers as one item of stack.
     * BFS(Breadth-first-search). or may be DFS(depth-first-search)
     *
     * @param root root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        Stack<List<TreeNode>> stack = new Stack<>();
        stack.add(Collections.singletonList(root));
        while (!stack.isEmpty()) {
            List<TreeNode> currentLevelNodes = stack.pop();
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            List<Integer> elements = new ArrayList<>();
            currentLevelNodes.forEach(item -> {
                elements.add(item.val);
                if (item.left != null) {
                    nextLevelNodes.add(item.left);
                }
                if (item.right != null) {
                    nextLevelNodes.add(item.right);
                }
            });
            result.add(0, elements);
            if (!nextLevelNodes.isEmpty()) {
                stack.push(nextLevelNodes);
            }
        }
        return result;
    }


}
