package algorithm.topics.unclassified;

/**
 * Binary Search Tree Node
 *
 * @author hufeng
 * @version Node.java, v 0.1 14/12/2017 12:22 AM Exp $
 */

public class Node<T extends Comparable<T>> {
    public T key = null;
    protected Node<T> parent = null;
    protected Node<T> left = null;
    protected Node<T> right = null;

    protected Node() {
    }

    protected Node(Node<T> parent, T key) {
        this.parent = parent;
        this.key = key;
    }

}
