package algorithm.topics.unclassified;

/**
 * Red-Black Tree Node
 *
 * @author hufeng
 * @version RBNode.java, v 0.1 14/12/2017 5:57 PM Exp $
 */

public class RBNode<T extends Comparable<T>> extends Node<T> {

    protected RBColor color;

    public RBNode() {
        super();
    }

    public RBNode(T key) {
        this.key = key;
    }


}
