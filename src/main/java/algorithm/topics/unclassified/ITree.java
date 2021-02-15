package algorithm.topics.unclassified;

/**
 * @author hufeng
 * @version ITree.java, v 0.1 14/12/2017 11:35 PM Exp $
 */

public interface ITree<T> {
    /**
     * Add node to the tree and return the Node.
     *
     * @param value
     */
    public boolean add(T value);


    /**
     * Remove first occurrence of value in the tree.
     *
     * @param value
     * @return
     */
    public T remove(T value);


    /**
     * Clear the entire tree.
     */
    public void clear();


    /**
     * Does the tree contains the value.
     *
     * @param value
     * @return
     */
    public boolean contains(T value);

    /**
     * Get the numbers of nodes in the tree.
     *
     * @return
     */
    public int size();

    /**
     * Validate the tree according to the invariants.
     *
     * @return
     */
    public boolean validate();


    public boolean isEmpty();
}
