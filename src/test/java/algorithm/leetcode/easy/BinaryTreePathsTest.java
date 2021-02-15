package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static algorithm.leetcode.easy.BinaryTreePaths.*;

class BinaryTreePathsTest {

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
        BinaryTreePaths.TreeNode root = sortedArray2BTree(arr);
        postOrderIterator(root);
        List<String> result = binaryTreePaths(root);
        result.forEach(System.out::println);
    }

    @Test
    public void testOneElement() {
        int[] arr = new int[]{1};
        BinaryTreePaths.TreeNode root = sortedArray2BTree(arr);
        List<String> result = binaryTreePaths(root);
        result.forEach(System.out::println);
    }

    @Test
    public void testEmptyElement() {
        BinaryTreePaths.TreeNode one = new BinaryTreePaths.TreeNode(1);
        BinaryTreePaths.TreeNode two = new BinaryTreePaths.TreeNode(2);
        BinaryTreePaths.TreeNode three = new BinaryTreePaths.TreeNode(3);
        BinaryTreePaths.TreeNode four = new BinaryTreePaths.TreeNode(4);
        one.left = two;
        one.right = three;
        two.left = four;

        List<String> result = binaryTreePaths(one);
        result.forEach(System.out::println);
    }

}