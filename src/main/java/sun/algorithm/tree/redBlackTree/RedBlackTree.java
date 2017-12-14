package sun.algorithm.tree.redBlackTree;

import org.junit.Before;
import org.junit.Test;
import sun.algorithm.tree.binarySearchTree.BinarySearchTree;

/**
 * <a href="http://www.geeksforgeeks.org/red-black-tree-set-2-insert/">red-black-tree-set-2-insert</a>
 * <a href="https://www.cs.usfca.edu/~galles/visualization/RedBlack.html">RedBlack</a>
 * <a href="https://www.cs.auckland.ac.nz/software/AlgAnim/red_black.html">red_black</a>
 * <a href="https://www.cs.auckland.ac.nz/software/AlgAnim/red_black_op.html">red_black_op</a>
 * <a href="https://www.cs.purdue.edu/homes/ayg/CS251/slides/chap13c.pdf">chap13c.pdf</a>
 * <p>
 * red-black properties:
 * 1. Every node is either red or black
 * 2. Every leaf is black
 * 3. If a node is red, then both its children are black.
 * 4. Every simple path from a node to a descendant leaf contains the same number of black nodes.
 * <p>
 * Lemma:
 * A red-black tree with n internal nodes has height at most 2log(n+1).
 * This demonstrates why the red-black tree is a good search tree: it can always be searched in O(log n) time.
 *
 * @author hufeng
 * @version RedBlackTree.java, v 0.1 10/12/2017 10:21 PM Exp $
 */

public class RedBlackTree {
    class Tree {
        Node root;
    }

    class Node {
        int val;
        Node left;
        Node right;
        Node parent;
        int color; // 0 black, 1 red
        int originalColor;

        Node() {
        }

        Node(int val) {
            this.val = val;
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
     * @param tree
     * @param x
     */
    public void leftRotate(Tree tree, Node x) {
        Node y = x.right;
        x.right = y.left;   // turn y's left subtree into x's right subtree
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent; // y's new parent was x's parent
        // Set the parent to point to y instead of x
        // First see whether we're at the root.
        if (x.parent == null) { // empty tree
            tree.root = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
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
     * @param tree
     * @param y
     */
    public void rightRotate(Tree tree, Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            tree.root = x;
        } else {
            if (y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

//
//    public void rbInsert(Tree tree, Node z) {
//        // Insert in the tree in the usual way
//        this.inser
//        Node y = null;
//        Node x = tree.root;
//        while (x != null) {
//            y = x;
//            if (z.val < x.val) {
//                x = x.left;
//            } else {
//                x = x.right;
//            }
//        }
//        z.parent = y;
//        if (y == null) {
//            tree.root = z;
//        } else {
//            if (z.val < y.val) {
//                y.left = z;
//            } else {
//                y.right = z;
//            }
//        }
//        z.left = null;
//        z.right = null;
//
//        // Now restore the red-black property
//        z.color = 1; // set color as red
//        rbInsertFixUp(tree, z);
//    }
//
//
//    public void rbInsertFixUp(Tree tree, Node z) {
//        // nil is considered as Black
//        while (z.parent != null && z.parent.color == 1) { // z.parent.color == RED
//            Node y = null;
//            if (z.parent == z.parent.parent.left) {
//                y = z.parent.parent.right; // z's uncle
//                if (y.color == 1) { // y.color == RED                   // case 1
//                    z.parent.color = 0; // z.parent.color = BLACK       // case 1
//                    y.color = 0;                                        // case 1
//                    z.parent.parent.color = 1; //RED                    // case 1
//                    z = z.parent.parent;                                // case 1
//                } else {
//                    // y is a black node
//                    if (z == z.parent.right) {
//                        // and x is to the right
//                        // case 2 - move z up and rotate
//                        z = z.parent;                                   // case 2
//                        leftRotate(tree, z);                            // case 2
//                    }
//                    // case 3
//                    z.parent.color = 0;                                 // case 3
//                    z.parent.parent.color = 1;                          // case 3
//                    rightRotate(tree, z.parent.parent);                 // case 3
//                }
//            } else {
//                y = z.parent.parent.left;
//                // nil is considered as Black
//                if (y != null && y.color == 1) {
//                    z.parent.color = 0;
//                    y.color = 0;
//                    z.parent.parent.color = 1;
//                    z = z.parent.parent;
//                } else {
//                    if (z == z.parent.left) {
//                        z = z.parent;
//                        rightRotate(tree, z);
//                    }
//                    // case 3
//                    z.parent.color = 0;
//                    z.parent.parent.color = 1;
//                    leftRotate(tree, z.parent.parent);
//                }
//            }
//        }
//        tree.root.color = 0;
//    }
//

    public void rbTransplant(Tree tree, Node u, Node v) {
        if (u.parent == null) {
            tree.root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
    }

    /**
     * Find the minimum key node
     * O(h)
     *
     * @param node
     * @return
     */
    public Node treeMinimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public void rbDelete(Tree tree, Node z) {
        Node y = z;
        Node x = null;
        y.originalColor = y.color;
        if (z.left == null) {
            x = z.right;
            rbTransplant(tree, z, z.right);
        } else if (z.right == null) {
            x = z.left;
            rbTransplant(tree, z, z.left);
        } else {
            y = treeMinimum(z.right); // y points to z's successor
            y.originalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(tree, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            rbTransplant(tree, x, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (y.originalColor == 0) { // black
            rbDeleteFixUp(tree, x);
        }
    }

    public void rbDeleteFixUp(Tree tree, Node x) {
        while (x != tree.root && x.color == 0) {
            if (x == x.parent.left) {
                Node w = x.parent.right;
                if (w.color == 1) {
                    w.color = 0;
                    x.parent.color = 1;
                    leftRotate(tree, x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == 0 && w.right.color == 0) {
                    w.color= 1;
                    x = x.parent;
                } else {
                    if (w.right.color == 0 && w.left.color == 0 && w.color == 1) {
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = 0;
                    w.right.color = 0;
                    leftRotate(tree, x.parent);
                    x = tree.root;
                }
            } else {
                //
            }
        }
        x.color = 0;
    }
//
//    @Test
//    public void testInsert() {
//        Tree tree = new Tree();
//        Node root = new Node(10);
//        root.color = 0; // black
//        tree.root = root;
//
//
//        Node node2 = new Node(20);
//        rbInsert(tree, node2);
//
//        Node node3 = new Node(30);
//        rbInsert(tree, node3);
//
//        Node node4 = new Node(15);
//        rbInsert(tree, node4);
//        System.out.println(tree.root);
//    }
}
