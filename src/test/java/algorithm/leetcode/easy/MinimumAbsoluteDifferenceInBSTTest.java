package algorithm.leetcode.easy;

import algorithm.leetcode.domain.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static algorithm.topics.binarytree.MinimumAbsoluteDifferenceInBST.getMinimumDifference;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAbsoluteDifferenceInBSTTest {

    private TreeNode root;

    @BeforeEach
    public void init() {
        root = new TreeNode(7);
        TreeNode a = new TreeNode(4);
        root.left = a;

        TreeNode b = new TreeNode(8);
        root.right = b;

        TreeNode c = new TreeNode(3);
        a.left = c;

    }


    @Test
    public void testNormalCase() {
        int result = getMinimumDifference(root);
        assertEquals(1, result);
    }

}