/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.datastructure.tree.bst;

/**
 * {@index Construct the BST}
 * Given preorder traversal of a binary search tree, construct the BST
 *
 * @author hufeng
 * @version $Id: ConstructFromPreorderTraversal.java, v 0.1 2018年12月12日 3:30 PM hufeng Exp $
 * <a href="https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/"/>
 */
public class ConstructFromPreorderTraversal {
    static class Node {
        int  data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public Node buildTree(int[] preorder) {
        return build(preorder, 0, 0, preorder.length - 1);
    }

    private Node build(int[] preorder, int preIndex, int low, int high) {
        // Base Case
        if (preIndex >= preorder.length || low > high) {
            return null;
        }

        // The first node in preorder traversal is root. So take the node at preIndex from pre[]
        // and make it root, and increment preIndex.
        Node root = new Node(preorder[preIndex]);

        // If the current subarray has only one element, no need to recur
        if (low == high) {
            return root;
        }

        // Search for the first element greater than root
        int i;
        for (i = low; i <= high; ++i) {
            if (preorder[i] > root.data) {
                break;
            }
        }
        // Use the index of element found in preorder to divide preorder array in two parts.
        // Left subtree and right subtree
        root.left = build(preorder, preIndex + 1, low, i - 1);
        root.right = build(preorder, preIndex + 1, i, high);
        return root;
    }

}