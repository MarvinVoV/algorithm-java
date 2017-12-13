package sun.algorithm.tree.binarySearchTree;

/**
 * Binary Search Tree Node
 *
 * @author hufeng
 * @version Node.java, v 0.1 14/12/2017 12:22 AM Exp $
 */

public class Node {
    int key;
    Node left;
    Node right;
    Node parent;

    Color color;

    Color originalColor;

    Node() {
    }

    Node(int key) {
        this.key = key;
    }

    enum Color {
        RED, BLACK
    }


    public Node addLeftChild(Node node) {
        this.left = node;
        node.parent = this;
        return this;
    }

    public Node addRightChild(Node node) {
        this.right = node;
        node.parent = this;
        return this;
    }
}
