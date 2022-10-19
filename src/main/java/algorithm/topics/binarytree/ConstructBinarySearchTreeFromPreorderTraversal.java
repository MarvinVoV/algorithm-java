package algorithm.topics.binarytree;

import algorithm.leetcode.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/">Construct binary search tree from preorder traversal</a>
 *
 * @author marvin
 * @version ConstructBinarySearchTreeFromPreorderTraversal.java, v 0.1 2022/10/19 23:27 Exp $
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    /**
     * 通过左右区间构建
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    /**
     * 根据preorder的子区间 [left...right]构建二叉树
     *
     * @param preorder
     * @param left
     * @param right
     * @return
     */
    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        if (left == right) {
            return root;
        }
        // 在区间 [left..right] 里找最后一个小于 preorder[left] 的下标
        // 注意这里设置区间的左边界为 left ，不能是 left + 1
        // 这是因为考虑到区间只有 2 个元素 [left, right] 的情况，第 1 个部分为空区间，第 2 部分只有一个元素 right
        int l = left;
        int r = right;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (preorder[mid] < preorder[left]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        TreeNode leftTree = dfs(preorder, left + 1, l);
        TreeNode rightTree = dfs(preorder, l + 1, right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    /**
     * 通过栈的方式实现
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder2(int[] preorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        for (int i = 1; i < len; i++) {
            // 将栈的最后一个元素作为父元素，并从下一个前序遍历的节点创建子节点
            TreeNode node = stack.peekLast();
            TreeNode currentNode = new TreeNode(preorder[i]);

            // 栈中小于当前节点值的元素全部出栈，当前节点连接到最后一个弹出栈的结点的右边
            while (!stack.isEmpty() && stack.peekLast().val < currentNode.val) {
                node = stack.removeLast();
            }

            if (node.val < currentNode.val) {
                node.right = currentNode;
            } else {
                node.left = currentNode;
            }
            stack.addLast(currentNode);
        }
        return root;
    }


}
