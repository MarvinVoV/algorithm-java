package algorithm.leetcode.easy;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import static algorithm.leetcode.easy.InvertBinaryTree.invertTree;

class InvertBinaryTreeTest {

    @Test
    public void testNormalCase() {
        InvertBinaryTree.TreeNode root = new InvertBinaryTree.TreeNode(0);
        InvertBinaryTree.TreeNode left = new InvertBinaryTree.TreeNode(1);
        InvertBinaryTree.TreeNode right = new InvertBinaryTree.TreeNode(2);
        root.left = left;
        root.right = right;

        InvertBinaryTree.TreeNode res = invertTree(root);
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void testComplexCase() {
        InvertBinaryTree.TreeNode root = new InvertBinaryTree.TreeNode(4);
        InvertBinaryTree.TreeNode l = new InvertBinaryTree.TreeNode(2);
        InvertBinaryTree.TreeNode r = new InvertBinaryTree.TreeNode(7);
        root.left = l;
        root.right = r;
        l.left = new InvertBinaryTree.TreeNode(1);
        l.right = new InvertBinaryTree.TreeNode(3);
        r.left = new InvertBinaryTree.TreeNode(6);
        r.right = new InvertBinaryTree.TreeNode(9);

        InvertBinaryTree.TreeNode res = invertTree(root);
        System.out.println(JSON.toJSONString(res));

    }

    @Test
    public void testNullCase() {
        InvertBinaryTree.TreeNode root = new InvertBinaryTree.TreeNode(0);
        InvertBinaryTree.TreeNode left = new InvertBinaryTree.TreeNode(1);
        root.left = left;
        InvertBinaryTree.TreeNode res = invertTree(root);
        System.out.println(JSON.toJSONString(res));
    }

}