package sun.algorithm.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

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
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

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


    @Test
    public void testNormalCase() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrderBottom(root);
        System.out.println(JSON.toJSONString(result));
        assertTrue(result.size() == 3);
    }

    @Test
    public void testNormalCase2() {
        TreeNode node = new TreeNode(3);
        List<List<Integer>> result = levelOrderBottom(node);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void testNormalCase3() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(4);
        right.right = new TreeNode(5);
        List<List<Integer>> result = levelOrderBottom(root);
        System.out.println(JSON.toJSONString(result));
    }


}
