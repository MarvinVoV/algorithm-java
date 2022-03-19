package algorithm.topics.datastructure.tree.traverse;

import java.util.*;

public class BinaryTreeTraverse {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static List<List<Integer>> levelTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    public static void main(String[] args) {
        /*
                 2
               /   \
              8    10
             / \   / \
            11 15  16 19
         */
        TreeNode root = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11= new TreeNode(11);
        TreeNode node15= new TreeNode(15);
        TreeNode node16= new TreeNode(16);
        TreeNode node19= new TreeNode(19);
        root.left = node8;
        root.right = node10;
        node8.left = node11;
        node8.right = node15;
        node10.left = node16;
        node10.right = node19;
        List<List<Integer>> result = levelTraversal(root);
        result.forEach(row -> {
            System.out.println(Arrays.toString(row.toArray()));
        });

    }
}
