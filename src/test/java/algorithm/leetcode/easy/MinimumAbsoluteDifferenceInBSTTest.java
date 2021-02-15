package algorithm.leetcode.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static algorithm.leetcode.easy.MinimumAbsoluteDifferenceInBST.getMinimumDifference;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAbsoluteDifferenceInBSTTest {

    private MinimumAbsoluteDifferenceInBST.TreeNode root;

    @BeforeEach
    public void init() {
        root = new MinimumAbsoluteDifferenceInBST.TreeNode(7);
        MinimumAbsoluteDifferenceInBST.TreeNode a = new MinimumAbsoluteDifferenceInBST.TreeNode(4);
        root.left = a;

        MinimumAbsoluteDifferenceInBST.TreeNode b = new MinimumAbsoluteDifferenceInBST.TreeNode(8);
        root.right = b;

        MinimumAbsoluteDifferenceInBST.TreeNode c = new MinimumAbsoluteDifferenceInBST.TreeNode(3);
        a.left = c;

    }


    @Test
    public void testNormalCase() {
        int result = getMinimumDifference(root);
        assertEquals(1, result);
    }

}