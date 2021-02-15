package algorithm.topics.unclassified;


import java.util.ArrayList;
import java.util.List;


/**
 * Binary Search Tree
 *
 * @author hufeng
 * @version BinarySearchTree.java, v 0.1 06/12/2017 11:37 PM Exp $
 */

public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {

    protected Node<T> root = null;

    protected int size = 0;

    public BinarySearchTree() {
    }


    @Override
    public boolean add(T value) {
        return insert(value) != null;
    }


    @Override
    public T remove(T value) {
        Node<T> node = search(value);
        Node<T> nodeToDel = deleteNode(node);
        return nodeToDel != null ? nodeToDel.key : null;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public boolean contains(T value) {
        Node<T> node = search(value);
        return node != null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean validate() {
        return isBST(root, null);
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    ///////////////////// PUBLIC OPERATIONS ////////////////////////
    protected Node<T> getRoot() {
        return this.root;
    }

    protected void insertNode(Node<T> newNode) {
        if (root == null) {
            root = newNode;
            size++;
            return;
        }
        Node<T> x = root;
        Node<T> y = null;  // trailing pointer always pointer to x'parent
        // move down the tree to find z's parent
        while (x != null) {
            y = x;
            if (newNode.key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        // insert newNode
        newNode.parent = y;
        if (newNode.key.compareTo(y.key) < 0) {
            y.left = newNode;
        } else {
            y.right = newNode;
        }
        size++;
    }

    protected Node<T> insert(T value) {
        if (value == null) {
            return null;
        }
        Node<T> newNode = new Node<>(null, value);
        insertNode(newNode);
        return newNode;
    }

    /**
     * Find the minimum key node
     * O(h)
     *
     * @param node
     * @return minimum key node
     */
    protected Node<T> findMin(Node<T> node) {
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
    protected Node<T> findMax(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * Find node's successor
     *
     * @param node
     * @return node's successor
     */
    public Node<T> findSuccessor(Node<T> node) {
        if (node.right != null) {
            return findMin(node.right);
        }
        Node x = node;
        Node y = node.parent;
        while (y != null && x == y.right) {
            x = y;
            y = x.parent;
        }
        return y;
    }

    public Node<T> getMin() {
        if (isEmpty()) {
            return null;
        }
        return findMin(this.root);
    }

    public Node<T> getMax() {
        if (isEmpty()) {
            return null;
        }
        return findMax(this.root);
    }

    /**
     * Search the node whose value is k through the iterative way. return null if not found.
     * O(h)
     *
     * @param value target value
     * @return target node
     */
    public Node<T> search(T value) {
        if (value == null) {
            return null;
        }

        Node<T> node = this.root;
        while (node != null && node.key.compareTo(value) != 0) {
            if (value.compareTo(node.key) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    protected Node<T> searchRecursively(T value) {
        if (value == null) {
            return null;
        }
        return searchRecursively(this.root, value);
    }

    /**
     * Search the node whose value is k recursively. return null if not found.
     *
     * @param node  node
     * @param value target value
     * @return target node
     */
    public Node<T> searchRecursively(Node<T> node, T value) {
        // Base case
        if (node == null || node.key.compareTo(value) == 0) {
            return node;
        }

        if (value.compareTo(node.key) < 0) {
            return searchRecursively(node.left, value);
        }
        return searchRecursively(node.right, value);
    }


    /**
     * Recursive implementation
     *
     * @param node
     * @param value
     * @return
     */
    private Node<T> insertRec(Node<T> node, T value) {
        if (node == null) {
            node = new Node<>(null, value);
            return node;
        }

        if (value.compareTo(node.key) < 0) {
            node.left = insertRec(node.left, value);
        } else if (value.compareTo(node.key) > 0) {
            node.right = insertRec(node.right, value);
        }
        // return the (unchanged) node pointer
        return node;
    }


    /**
     * v replace u
     *
     * @param u
     * @param v
     */
    protected void transplant(Node<T> u, Node<T> v) {
        if (u.parent == null) {
            this.root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }

    /**
     * Delete first occurrence of value in the tree.
     *
     * @param node
     * @return
     */
    protected Node<T> deleteNode(Node<T> node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            transplant(node, node.right);                 // case 1
        } else if (node.right == null) {
            transplant(node, node.left);                  // case 2
        } else { // node has two children
            Node<T> y = findMin(node.right);
            if (y.parent != node) {                      // case 3.1 : y is not node's right child
                transplant(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            }
            transplant(node, y);                         // case 3.2: y is node's right child
            y.left = node.left;
            y.left.parent = y;
        }
        size--;
        return node;
    }

    /**
     * Using In-order Traversal
     * Time Complexity: O(n)
     *
     * @param node
     * @param prev
     * @return
     */
    private boolean isBST(Node<T> node, Node<T> prev) {
        if (node == null) {
            return true;
        }
        if (!isBST(node.left, prev)) {
            return false;
        }
        // allows only distinct values node
        if (prev != null && node.key.compareTo(prev.key) <= 0) {
            return false;
        }
        prev = node;
        return isBST(node.right, prev);
    }


    @Override
    public String toString() {
        return TreePrinter.getString(this);
    }


    protected static class TreePrinter {

        public static <T extends Comparable<T>> String getString(BinarySearchTree<T> tree) {
            if (tree.root == null)
                return "Tree has no nodes.";
            return getString(tree.root, "", true);
        }

        private static <T extends Comparable<T>> String getString(Node<T> node, String prefix, boolean isTail) {
            StringBuilder builder = new StringBuilder();

            if (node.parent != null) {
                String side = "left";
                if (node.equals(node.parent.right))
                    side = "right";
                builder.append(prefix + (isTail ? "└── " : "├── ") + "(" + side + ") " + node.key + "\n");
            } else {
                builder.append(prefix + (isTail ? "└── " : "├── ") + node.key + "\n");
            }
            List<Node<T>> children = null;
            if (node.left != null || node.right != null) {
                children = new ArrayList<Node<T>>(2);
                if (node.left != null)
                    children.add(node.left);
                if (node.right != null)
                    children.add(node.right);
            }
            if (children != null) {
                for (int i = 0; i < children.size() - 1; i++) {
                    builder.append(getString(children.get(i), prefix + (isTail ? "    " : "│   "), false));
                }
                if (children.size() >= 1) {
                    builder.append(getString(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true));
                }
            }

            return builder.toString();
        }
    }
}
