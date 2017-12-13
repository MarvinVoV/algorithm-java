package sun.algorithm.tree.binarySearchTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    /**
     * Search the node whose value is k recursively. return null if not found.
     * O(h)
     *
     * @param node node
     * @param k    target value
     * @return target node
     */
    public Node search(Node node, int k) {
        // Base Case: root is null or key is present at root
        if (node == null || node.key == k) {
            return node;
        }
        if (k < node.key) {
            return search(node.left, k);
        }
        return search(node.right, k);
    }

    /**
     * Search the node whose value is k through the iterative way. return null if not found.
     *
     * @param node node
     * @param k    target value
     * @return target node
     */
    public Node iterativeSearch(Node node, int k) {
        while (node != null && k != node.key) {
            if (k < node.key) {
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
     * @return minimum key node
     */
    public Node minimum(Node node) {
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
    public Node maximum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }


    /**
     * Find node's successor
     *
     * @param x
     * @return node's successor
     */
    public Node successor(Node x) {
        if (x.right != null) {
            return minimum(x.right);
        }
        Node y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = x.parent;
        }
        return y;
    }

    /**
     * @param root bst
     * @param key  add new node whose key is the value.
     * @return root node
     */
    public Node insert(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }
        Node z = new Node(key); // new node
        Node y = null; // trailing pointer always pointer to x'parent
        Node x = root;

        // move down the tree to find z's parent
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        // insert node z
        z.parent = y;
        if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        return root;
    }

    /**
     * Recursive implementation
     *
     * @param root
     * @param key
     * @return
     */
    public Node insertRecursive(Node root, int key) {
        root = insertRec(root, key);
        return root;
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // return the (unchanged) node pointer
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
     * Delete node z in the bst
     *
     * @param root
     * @param z
     */
    public void delete(Node root, Node z) {
        if (z.left == null) {                                   // case 1
            transplant(root, z, z.right);
        } else if (z.right == null) {                           // case 2
            transplant(root, z, z.left);
        } else {  // z has two children
            Node y = minimum(z.right);
            if (y.parent != z) { // y is not z's right child    // case 3.1
                transplant(root, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(root, z, y);                             // case 3.2
            y.left = z.left;
            y.left.parent = y;
        }
    }

    /**
     * Using In-order Traversal
     * Time Complexity: O(n)
     *
     * @param root
     * @return
     */
    public boolean isBinarySearchTree(Node root) {
        if (root == null) {
            return false;
        }

        return isBST(root, null);
    }

    private boolean isBST(Node node, Node prev) {
        if (node == null) {
            return true;
        }
        if (!isBST(node.left, prev)) {
            return false;
        }
        // allows only distinct values node
        if (prev != null && node.key <= prev.key) {
            return false;
        }
        prev = node;
        return isBST(node.right, prev);
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
        root.addLeftChild(a).addRightChild(b);


        Node c = new Node(3);
        Node d = new Node(12);
        Node e = new Node(20);
        Node f = new Node(10);
        Node g = new Node(13);
        Node h = new Node(18);
        Node i = new Node(23);
        Node j = new Node(6);
        Node k = new Node(7);

        b.addRightChild(e);
        a.addLeftChild(c).addRightChild(d);
        d.addLeftChild(f).addRightChild(g);
        f.addLeftChild(j);
        j.addRightChild(k);

        e.addLeftChild(h);
        e.addRightChild(i);
    }

    @Test
    public void testSearch() {
        int k = 13;
        Node t = search(root, k);
        assertEquals(13, t.key);
    }

    @Test
    public void testSearchIterative() {
        int k = 13;
        Node t = iterativeSearch(root, k);
        assertEquals(13, t.key);
    }

    @Test
    public void testFindMinimum() {
        Node min = minimum(root);
        assertEquals(3, min.key);
    }

    @Test
    public void testFindMaximum() {
        Node max = maximum(root);
        assertEquals(23, max.key);
    }

    @Test
    public void testFindSuccessor() {
        Node target = search(root, 13); // 13's successor is 15
        Node successor = successor(target);
        assertEquals(15, successor.key);
    }

    @Test
    public void testInsertNode() {
        Node r = insert(root, 11);
        Node p = search(r, 10);
        assertEquals(11, p.right.key);
    }

    @Test
    public void testDelete() {
        Node z = search(root, 12);
        delete(root, z);
        assertEquals(13, search(root, 5).right.key);
    }

    @Test
    public void testIsBST() {
        assertTrue(isBinarySearchTree(root));
    }
}
