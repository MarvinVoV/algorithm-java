package algorithm.leetcode.easy;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeLevelOrderTraversal2Test {

    @Test
    public void testNormalCase() {
        BinaryTreeLevelOrderTraversal2.TreeNode root = new BinaryTreeLevelOrderTraversal2.TreeNode(3);
        root.left = new BinaryTreeLevelOrderTraversal2.TreeNode(9);
        BinaryTreeLevelOrderTraversal2.TreeNode right = new BinaryTreeLevelOrderTraversal2.TreeNode(20);
        root.right = right;
        right.left = new BinaryTreeLevelOrderTraversal2.TreeNode(15);
        right.right = new BinaryTreeLevelOrderTraversal2.TreeNode(7);

        List<List<Integer>> result = BinaryTreeLevelOrderTraversal2.levelOrderBottom(root);
        System.out.println(JSON.toJSONString(result));
        assertEquals(result.size(), 3);
    }

    @Test
    public void testNormalCase2() {
        BinaryTreeLevelOrderTraversal2.TreeNode node = new BinaryTreeLevelOrderTraversal2.TreeNode(3);
        List<List<Integer>> result = BinaryTreeLevelOrderTraversal2.levelOrderBottom(node);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void testNormalCase3() {
        BinaryTreeLevelOrderTraversal2.TreeNode root = new BinaryTreeLevelOrderTraversal2.TreeNode(1);
        BinaryTreeLevelOrderTraversal2.TreeNode left = new BinaryTreeLevelOrderTraversal2.TreeNode(2);
        BinaryTreeLevelOrderTraversal2.TreeNode right = new BinaryTreeLevelOrderTraversal2.TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = new BinaryTreeLevelOrderTraversal2.TreeNode(4);
        right.right = new BinaryTreeLevelOrderTraversal2.TreeNode(5);
        List<List<Integer>> result = BinaryTreeLevelOrderTraversal2.levelOrderBottom(root);
        System.out.println(JSON.toJSONString(result));
    }

}