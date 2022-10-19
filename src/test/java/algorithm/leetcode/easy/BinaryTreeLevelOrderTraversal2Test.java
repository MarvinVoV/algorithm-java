package algorithm.leetcode.easy;

import algorithm.leetcode.domain.TreeNode;
import algorithm.topics.binarytree.BinaryTreeLevelOrderTraversal2;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeLevelOrderTraversal2Test {

    @Test
    public void testNormalCase() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        List<List<Integer>> result = BinaryTreeLevelOrderTraversal2.levelOrderBottom(root);
        System.out.println(JSON.toJSONString(result));
        assertEquals(result.size(), 3);
    }

    @Test
    public void testNormalCase2() {
        TreeNode node = new TreeNode(3);
        List<List<Integer>> result = BinaryTreeLevelOrderTraversal2.levelOrderBottom(node);
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
        List<List<Integer>> result = BinaryTreeLevelOrderTraversal2.levelOrderBottom(root);
        System.out.println(JSON.toJSONString(result));
    }

}