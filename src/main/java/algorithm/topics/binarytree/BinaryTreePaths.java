package algorithm.topics.binarytree;

import java.util.ArrayList;
import java.util.List;

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
    public static class TreeNode {
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
    public static TreeNode sortedArray2BTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return sortedArray2BTree(arr, 0, arr.length - 1);
    }

    private static TreeNode sortedArray2BTree(int[] arr, int start, int end) {
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
    public static void postOrderIterator(TreeNode node) {
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
    public static void preOrderIterator(TreeNode node) {
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
    public static void inOrderIterator(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderIterator(node.left);
        System.out.println(node.val); // print node value
        postOrderIterator(node.right);
    }


    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null)
            searchBT(root, "", answer);
        return answer;
    }

    private static void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null)
            answer.add(path + root.val);
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", answer);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", answer);
        }
    }


    /**
     * 输出二叉树的所有路径
     * https://leetcode-cn.com/problems/binary-tree-paths/
     *
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    private static void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(sb.toString());
        } else {
            sb.append("->");
            dfs(root.left, sb.toString(), paths);
            dfs(root.right, sb.toString(), paths);
        }
    }
}
