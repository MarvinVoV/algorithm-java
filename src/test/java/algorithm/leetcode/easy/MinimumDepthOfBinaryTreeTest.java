package algorithm.leetcode.easy;

import algorithm.leetcode.domain.TreeNode;
import org.junit.jupiter.api.Test;

import static algorithm.topics.binarytree.MinimumDepthOfBinaryTree.minDepth;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDepthOfBinaryTreeTest {

    @Test
    public void testNormalCase() {
        TreeNode root = new TreeNode(0);

        int minDepth = minDepth(root);
        assertEquals(1, minDepth);
    }

}