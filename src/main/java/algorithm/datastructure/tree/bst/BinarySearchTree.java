/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.datastructure.tree.bst;

/**
 * {@index Binary Search Tree}
 *
 * @author hufeng
 * @version $Id: BinarySearchTree.java, v 0.1 2018年12月12日 2:12 PM hufeng Exp $
 * @see <a href="https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/"/>
 */
public class BinarySearchTree {
    public static class Node {
        int  key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls insertsRec()
    public void insert(int key) {
        root = insertRec(root, key);
    }

    public void inorder() {
        inorderRec(root);
    }

    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    /**
     * A recursive function to insert a new key in BST
     *
     * @param root bst root node
     * @param key  target key
     * @return bst root node
     */
    private Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }
        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // Return the (unchanged) node pointer
        return root;
    }

    private Node deleteRec(Node root, int key) {
        // Base Case: If the tree is empty
        if (root == null) return root;
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else { // If the key is same as root's key, then This is the node to be deleted.
            // node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    /**
     * A utility function to search a given key in BSF
     *
     * @param root
     * @param key
     * @return
     */
    private Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key) {
            return root;
        }
        // Value is greater than root's key
        if (key > root.key) {
            return search(root.right, key);
        }
        // Value is less than root's key
        return search(root.left, key);
    }

    /**
     * A utility function to do inorder traversal of BST
     *
     * @param root
     */
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }

}