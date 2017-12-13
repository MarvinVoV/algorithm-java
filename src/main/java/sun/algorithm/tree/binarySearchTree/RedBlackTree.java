package sun.algorithm.tree.binarySearchTree;

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
 * @version RedBlackTree.java, v 0.1 14/12/2017 2:40 AM Exp $
 */

public class RedBlackTree extends BinarySearchTree {

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
}
