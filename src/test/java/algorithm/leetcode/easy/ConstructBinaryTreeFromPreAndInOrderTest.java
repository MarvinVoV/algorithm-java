package algorithm.leetcode.easy;

import algorithm.leetcode.domain.TreeNode;
import org.junit.jupiter.api.Test;

import static algorithm.topics.binarytree.ConstructBinaryTreeFromPreAndInOrder.buildTree;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ConstructBinaryTreeFromPreAndInOrderTest {

    /**
     * <pre>
     *              1
     *            /   \
     *           2    3
     *          / \
     *         4   5
     * </pre>
     */
    @Test
    public void testNormalCase() {
        int[] preorder = new int[]{1, 2, 4, 5, 3};
        int[] inorder = new int[]{4, 2, 5, 1, 3};
        TreeNode tree = buildTree(preorder, inorder);
        assertNotNull(tree);
    }

    @Test
    public void testNormalCase2() {
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};
        TreeNode tree = buildTree(preorder, inorder);
        assertNotNull(tree);
    }

    @Test
    public void testNormalCase3() {
        int[] inorder = new int[]{1, 2, 3, 4};
        int[] preorder = new int[]{2, 1, 3, 4};
        TreeNode tree = buildTree(preorder, inorder);
        assertNotNull(tree);
    }

    @Test
    public void testNormalCase4() {
        int[] inorder = new int[]{1, 2, 3, 4, 5};
        int[] preorder = new int[]{1, 5, 2, 4, 3};
        TreeNode tree = buildTree(preorder, inorder);
        assertNotNull(tree);
    }

    @Test
    public void testBoundaryCondition() {
        int[] preorder = new int[]{1};
        int[] inorder = new int[]{1};
        TreeNode tree = buildTree(preorder, inorder);
        assertNotNull(tree);
    }

    @Test
    public void testBoundaryCondition2() {
        int[] preorder = new int[]{};
        int[] inorder = new int[]{};
        TreeNode tree = buildTree(preorder, inorder);
        assertNull(tree);
    }

}