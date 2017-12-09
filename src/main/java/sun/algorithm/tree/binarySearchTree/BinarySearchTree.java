package sun.algorithm.tree.binarySearchTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <pre>
 *                   15
 *                 /    |
 *                6     18
 *               / \    / \
 *              3   7  17 20
 *             / \   \
 *            2  4   13
 *                   /
 *                  9
 * </pre>
 *
 * @author hufeng
 * @version BinarySearchTree.java, v 0.1 06/12/2017 11:37 PM Exp $
 */

public class BinarySearchTree {

    class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int x) {
            val = x;
        }

        Node addLeft(Node node) {
            this.left = node;
            node.parent = this;
            return this;
        }

        Node addRight(Node node) {
            this.right = node;
            node.parent = this;
            return this;
        }
    }


    /**
     * Search the node whose value is k recursively. return null if not found.
     * O(h)
     *
     * @param node node
     * @param k    target value
     * @return target node
     */
    public Node treeSearch(Node node, int k) {
        if (node == null || node.val == k) {
            return node;
        }
        if (k < node.val) {
            return treeSearch(node.left, k);
        }
        return treeSearch(node.right, k);
    }

    /**
     * Search the node whose value is k through the iterative way. return null if not found.
     *
     * @param node node
     * @param k    target value
     * @return target node
     */
    public Node iterativeTreeSearch(Node node, int k) {
        while (node != null && k != node.val) {
            if (k < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
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

    /**
     * Find the maximum key node
     * O(h)
     *
     * @param node
     * @return
     */
    public Node treeMaximum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }


    /**
     * Find node's successor
     * 15's successor -> 17
     * 13's successor -> 15
     *
     * @param node
     * @return
     */
    public Node treeSuccessor(Node node) {
        if (node.right != null) {
            return treeMinimum(node.right);
        }
        Node y = node.parent;
        while (y != null && node == y.right) {
            node = y;
            y = node.parent;
        }
        return y;
    }

    /**
     * @param root bst
     * @param z    node which will be inserted into the bst
     * @return root node
     */
    public Node treeInsert(Node root, Node z) {
        Node y = null; // trailing pointer
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
            root = z; // empty T
        } else if (z.val < y.val) {
            y.left = z;
        } else {
            y.right = z;
        }
        return root;
    }

    /**
     * v replace u
     *
     * @param t
     * @param u
     * @param v
     */
    public Node transplant(Node t, Node u, Node v) {
        if (u.parent == null) {
            t = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
        return t;
    }

    /**
     * Delete node z from bst.
     * Three Case:
     * 1. target node has no children.
     * 2. target node has one child.
     * 3. target node has two children.
     *
     * @param root bst
     * @param z    target node which would be delete.
     */
    public Node treeDelete(Node root, Node z) {
        Node y; // Determine a node y to splice out.
        if (z.left == null || z.right == null) {  // target node has at most 1 child.
            y = z;
        } else { // target node has two children.
            y = treeSuccessor(z);
        }

        Node x; // x is set to the non-nil child of y, or to nil if y has no children.
        if (y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }
        if (x != null) {
            x.parent = y.parent;
        }
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        // Finally, if the successor of z was the node spliced out, y's key and satellite data are moved to z,
        // overwriting the previous key and satellite data.
        if (y != z) {
            z.val = y.val;
        }
        return y;
    }

    public void treeDelete2(Node t, Node z) {
        if (z.left == null) {
            transplant(t, z, z.right);
        } else if (z.right == null) {
            transplant(t, z, z.left);
        } else {
            Node y = treeMinimum(z.right);
            if (y.parent != z) { // y is not z's right child
                transplant(t, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(t, z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }


    private Node root;

    @Before
    public void buildBinarySearchTree() {

        /**
         * <pre>
         *                   15
         *                 /    \
         *                5      16
         *               / \       \
         *              3   12     20
         *                 / \     / \
         *                10  13  18 23
         *               /
         *              6
         *               \
         *                7
         * </pre>
         */
        root = new Node(15);
        Node a = new Node(5);
        Node b = new Node(16);
        root.addLeft(a).addRight(b);


        Node c = new Node(3);
        Node d = new Node(12);
        Node e = new Node(20);
        Node f = new Node(10);
        Node g = new Node(13);
        Node h = new Node(18);
        Node i = new Node(23);
        Node j = new Node(6);
        Node k = new Node(7);

        b.addRight(e);
        a.addLeft(c).addRight(d);
        d.addLeft(f).addRight(g);
        f.addLeft(j);
        j.addRight(k);

        e.addLeft(h);
        e.addRight(i);
    }

    @Test
    public void testSearch() {
        int k = 13;
        Node t = treeSearch(root, k);
        assertEquals(13, t.val);
    }

    @Test
    public void testSearchIterative() {
        int k = 13;
        Node t = iterativeTreeSearch(root, k);
        assertEquals(13, t.val);
    }

    @Test
    public void testFindMinimum() {
        Node min = treeMinimum(root);
        assertEquals(3, min.val);
    }

    @Test
    public void testFindMaximum() {
        Node max = treeMaximum(root);
        assertEquals(23, max.val);
    }

    @Test
    public void testFindSuccessor() {
        Node target = treeSearch(root, 13); // 13's successor is 15
        Node successor = treeSuccessor(target);
        assertEquals(15, successor.val);
    }

    @Test
    public void testInsertNode() {
        Node z = new Node(11);
        Node r = treeInsert(root, z);
        Node p = treeSearch(r, 10);
        assertEquals(11, p.right.val);
    }

    @Test
    public void testDelete() {
        Node z = treeSearch(root, 12);
        treeDelete2(root, z);
        assertEquals(13, treeSearch(root, 5).right.val);
    }
}
