package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static algorithm.leetcode.easy.MinimumDepthOfBinaryTree.minDepth;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDepthOfBinaryTreeTest {

    @Test
    public void testNormalCase() {
        MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(0);

        int minDepth = minDepth(root);
        assertEquals(1, minDepth);
    }

}