package sun.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 * <pre>
 *   1
 * /   \
 * 2    3
 * \
 * 5
 * </pre>
 * <p>
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * <p>
 * Reference: <a href="https://leetcode.com/problems/binary-tree-paths/description/">Binary Tree Paths</a>
 *
 * @author hufeng
 * @version BinaryTreePaths.java, v 0.1 19/10/2017 8:57 PM Exp $
 */

public class BinaryTreePaths {

    /**
     * Definition for a binary tree node
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Convert sorted array to binary tree.
     *
     * @param arr sorted array.
     * @return root node of binary tree.
     */
    public TreeNode sortedArray2BTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return sortedArray2BTree(arr, 0, arr.length - 1);
    }

    private TreeNode sortedArray2BTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortedArray2BTree(arr, start, mid - 1);
        root.right = sortedArray2BTree(arr, mid + 1, end);
        return root;
    }

    /**
     * Post Order Iterator
     *
     * @param node node
     */
    public void postOrderIterator(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderIterator(node.left);
        postOrderIterator(node.right);
        System.out.println(node.val); // print node value

    }

    /**
     * Pre Order Iterator
     *
     * @param node node
     */
    public void preOrderIterator(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val); // print node value
        postOrderIterator(node.left);
        postOrderIterator(node.right);
    }

    /**
     * In Order Iterator
     *
     * @param node node
     */
    public void inOrderIterator(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderIterator(node.left);
        System.out.println(node.val); // print node value
        postOrderIterator(node.right);
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null)
            searchBT(root, "", answer);
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null)
            answer.add(path + root.val);
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", answer);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", answer);
        }
    }



    @Test
    public void testSolution() {
        /**
         * <pre>
         *             3
         *          /    \
         *          1     4
         *           \     \
         *            2     5
         * </pre>
         */

        int[] arr = new int[]{1, 2, 3, 4, 5};
        TreeNode root = sortedArray2BTree(arr);
        postOrderIterator(root);
        List<String> result = binaryTreePaths(root);
        result.forEach(System.out::println);
    }

    @Test
    public void testOneElement() {
        int[] arr = new int[]{1};
        TreeNode root = sortedArray2BTree(arr);
        List<String> result = binaryTreePaths(root);
        result.forEach(System.out::println);
    }

    @Test
    public void testEmptyElement() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        one.left = two;
        one.right = three;
        two.left = four;

        List<String> result = binaryTreePaths(one);
        result.forEach(System.out::println);
    }


}
