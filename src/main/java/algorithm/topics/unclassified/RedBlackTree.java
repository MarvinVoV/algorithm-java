package algorithm.topics.unclassified;

/**
 * <a href="http://www.geeksforgeeks.org/red-black-tree-set-2-insert/">red-black-tree-set-2-insert</a>
 * <a href="https://www.cs.usfca.edu/~galles/visualization/RedBlack.html">RedBlack</a>
 * <a href="https://www.cs.auckland.ac.nz/software/AlgAnim/red_black.html">red_black</a>
 * <a href="https://www.cs.auckland.ac.nz/software/AlgAnim/red_black_op.html">red_black_op</a>
 * <a href="https://www.cs.purdue.edu/homes/ayg/CS251/slides/chap13c.pdf">chap13c.pdf</a>
 * <a href="http://www.geeksforgeeks.org/red-black-tree-set-3-delete-2/">Red Black Delete</a>
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

public class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {


    public RBNode<T> getRoot() {
        return (RBNode<T>) this.root;
    }

    @Override
    public boolean add(T key) {
        if (key == null) {
            return false;
        }

        RBNode<T> addNode = new RBNode<>();
        addNode.key = key;

        insertNode(addNode);
        return true;
    }

    @Override
    public T remove(T value) {
        if (value == null) {
            return null;
        }
        RBNode<T> delNode = (RBNode<T>) search(value);
        this.deleteNode(delNode);
        return value;
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
     * @param x
     */
    protected void leftRotate(RBNode<T> x) {
        RBNode<T> y = (RBNode<T>) x.right;
        assert y != null; // since the leaves of a red-black tree are empty, they cannot become internal nodes.
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        // Set the parent to point to y instead of x
        // First see whether we're at the root.
        if (x.parent == null) { // empty tree
            this.root = y;
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
     * @param y
     */
    protected void rightRotate(RBNode<T> y) {
        RBNode<T> x = (RBNode<T>) y.left;
        assert x != null;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            this.root = x;
        } else if (y.parent.left == y) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }

    protected void insertNode(RBNode<T> z) {
        // Insert in the tree in the usual way
        super.insertNode(z);

        z.left = null;
        z.right = null;
        z.color = RBColor.RED;

        // Now restore the red-black property
        insertFixUp(z);

        size++;
    }

    protected void insertFixUp(RBNode<T> z) {
        while (z != this.root && ((RBNode<T>) z.parent).color == RBColor.RED) {
            RBNode<T> y;
            if (z.parent == z.parent.parent.left) {
                y = (RBNode<T>) z.parent.parent.right;
                if (y != null && y.color == RBColor.RED) {               // case 1
                    ((RBNode<T>) z.parent).color = RBColor.BLACK;        // case 1
                    y.color = RBColor.BLACK;                             // case 1
                    ((RBNode<T>) z.parent.parent).color = RBColor.RED;   // case 1
                    z = (RBNode<T>) z.parent.parent;                     // case 1
                } else {
                    if (z == z.parent.right) {
                        z = (RBNode<T>) z.parent;                        // case 2
                        leftRotate(z);                                   // case 2
                    }
                    // case 3
                    ((RBNode<T>) z.parent).color = RBColor.RED;          // case 3
                    ((RBNode<T>) z.parent.parent).color = RBColor.BLACK; // case 3
                    rightRotate((RBNode<T>) z.parent.parent);            // case 3
                }
            } else {
                y = (RBNode<T>) z.parent.parent.left;
                if (y != null && y.color == RBColor.RED) {
                    ((RBNode<T>) z.parent).color = RBColor.BLACK;
                    y.color = RBColor.BLACK;
                    ((RBNode<T>) z.parent.parent).color = RBColor.RED;
                    z = (RBNode<T>) z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = (RBNode<T>) z.parent;
                        rightRotate(z);
                    }
                    ((RBNode<T>) z.parent).color = RBColor.BLACK;
                    ((RBNode<T>) z.parent.parent).color = RBColor.RED;
                    leftRotate((RBNode<T>) z.parent.parent);
                }
            }
        }
        ((RBNode<T>) this.root).color = RBColor.BLACK;
    }

    protected void rbTransplant(RBNode<T> u, RBNode<T> v) {
        if (u.parent == null) {
            this.root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }


    protected void deleteNode(RBNode<T> z) {
        RBNode<T> y = z;
        RBNode<T> x;
        RBColor yOriginalColor = y.color;
        if (z.left == null) {
            x = (RBNode<T>) z.right;
            rbTransplant(z, (RBNode<T>) z.right);
        } else if (z.right == null) {
            x = (RBNode<T>) z.left;
            rbTransplant(z, (RBNode<T>) z.left);
        } else {
            y = (RBNode<T>) findMin(z.right); // y points to z's successor
            yOriginalColor = y.color;
            x = (RBNode<T>) y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, (RBNode<T>) y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            rbTransplant(x, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == RBColor.BLACK) {
            deleteFixUp(x);
        }
        size--;
    }

    protected void deleteFixUp(RBNode<T> x) {
        while (x != this.root && (x != null && x.color == RBColor.RED)) {
            RBNode<T> w;
            if (x == x.parent.left) {
                w = (RBNode<T>) x.parent.right;
                if (w == null) {
                    throw new RuntimeException("x's sibling should not be null");
                }

                if (w.color == RBColor.RED) {  // case 1
                    w.color = RBColor.BLACK;
                    ((RBNode<T>) x.parent).color = RBColor.RED;
                    leftRotate((RBNode<T>) x.parent);
                    w = (RBNode<T>) x.parent.right;
                }
                if ((w.left == null || ((RBNode<T>) w.left).color == RBColor.BLACK)
                        && (w.right == null || ((RBNode<T>) w.right).color == RBColor.BLACK)) { // case 2
                    w.color = RBColor.RED;
                    x = (RBNode<T>) x.parent;
                } else {
                    if (w.right != null && ((RBNode<T>) w.right).color == RBColor.BLACK) { // case 3
                        if (w.left != null) {
                            ((RBNode<T>) w.left).color = RBColor.BLACK;
                        }
                        w.color = RBColor.RED;
                        rightRotate(w);
                        w = (RBNode<T>) x.parent.right;
                    }
                    w.color = ((RBNode<T>) x.parent).color;      // case 4
                    ((RBNode<T>) x.parent).color = RBColor.BLACK;
                    if (w.right != null) {
                        ((RBNode<T>) w.right).color = RBColor.BLACK;
                    }
                    leftRotate((RBNode<T>) x.parent);
                    x = (RBNode<T>) this.root;
                }
            } else {
                w = (RBNode<T>) x.parent.left;
                if (w == null) {
                    throw new RuntimeException("x's sibling should not be null");
                }

                if (w.color == RBColor.RED) {  // case 1
                    w.color = RBColor.BLACK;
                    ((RBNode<T>) x.parent).color = RBColor.RED;
                    rightRotate((RBNode<T>) x.parent);
                    w = (RBNode<T>) x.parent.left;
                }

                if ((w.right == null || ((RBNode<T>) w.right).color == RBColor.BLACK)
                        && (w.left == null || ((RBNode<T>) w.left).color == RBColor.BLACK)) { // case 2
                    w.color = RBColor.RED;
                    x = (RBNode<T>) x.parent;
                } else {
                    if (w.left != null && ((RBNode<T>) w.left).color == RBColor.BLACK) { // case 3
                        if (w.right != null) {
                            ((RBNode<T>) w.right).color = RBColor.BLACK;
                        }
                        w.color = RBColor.RED;
                        leftRotate(w);
                        w = (RBNode<T>) x.parent.left;
                    }
                    w.color = ((RBNode<T>) x.parent).color;      // case 4
                    ((RBNode<T>) x.parent).color = RBColor.BLACK;
                    if (w.left != null) {
                        ((RBNode<T>) w.left).color = RBColor.BLACK;
                    }
                    rightRotate((RBNode<T>) x.parent);
                    x = (RBNode<T>) this.root;
                }
            }
        }
        if (x != null) {
            x.color = RBColor.RED;
        }
    }

}
