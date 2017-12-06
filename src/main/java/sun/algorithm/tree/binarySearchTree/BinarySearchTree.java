package sun.algorithm.tree.binarySearchTree;

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


    public void treeInsert(Node root, Node z) {
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
    }
    // todo delete operation



}
