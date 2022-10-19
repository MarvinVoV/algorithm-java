package algorithm.leetcode.easy;

import algorithm.leetcode.domain.TreeNode;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import static algorithm.topics.binarytree.InvertBinaryTree.invertTree;

class InvertBinaryTreeTest {

    @Test
    public void testNormalCase() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        TreeNode res = invertTree(root);
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void testComplexCase() {
        TreeNode root = new TreeNode(4);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(7);
        root.left = l;
        root.right = r;
        l.left = new TreeNode(1);
        l.right = new TreeNode(3);
        r.left = new TreeNode(6);
        r.right = new TreeNode(9);

        TreeNode res = invertTree(root);
        System.out.println(JSON.toJSONString(res));

    }

    @Test
    public void testNullCase() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        root.left = left;
        TreeNode res = invertTree(root);
        System.out.println(JSON.toJSONString(res));
    }

}