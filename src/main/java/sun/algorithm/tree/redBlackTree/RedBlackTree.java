package sun.algorithm.tree.redBlackTree;

/**
 * @author hufeng
 * @version RedBlackTree.java, v 0.1 10/12/2017 10:21 PM Exp $
 */

public class RedBlackTree {
    class Node {
        int val;
        Node left;
        Node right;
        Node parent;
        int color; // 0 black, 1 red

        Node() {
        }

        Node(int val, int color) {
            this.val = val;
            this.color = color;
        }
    }


    /**
     * <pre>
     *      x                          y
     *     / \      left-rotate       / \
     *    a   y     ----------->     x   r
     *       / \                    / \
     *      b   r                  a   b
     * </pre>
     *
     * @param root
     * @param x
     */
    public void leftRotate(Node root, Node x) {
        Node y = x.right; // assert x.right != null
        x.right = y.left;   // turn y's left subtree into x's right subtree
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent; // link x's parent to y
        if (x.parent == null) { // empty tree
            root = y;
        } else if (x.parent.left == x) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x; // put x on y's left
        x.parent = y;
    }

    /**
     * <pre>
     *      y                           x
     *     / \      right-rotate       / \
     *    x   r     ----------->      a   y
     *   / \                             / \
     *  a   b                           b   r
     * </pre>
     *
     * @param root
     * @param y
     */
    public void rightRotate(Node root, Node y) {
        Node x = y.left; // assert y.left != null
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y.parent.left == y) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }



    public void rbInsert(Node root, Node z) {
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            if (z.val < x.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (z.val < y.val) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = null;
        z.right = null;
        z.color = 1; // set color as red

    }
}
