package java.algorithm.tree.binarySearchTree;

import algorithm.topics.unclassified.BinarySearchTree;
import algorithm.topics.unclassified.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author hufeng
 * @version BinarySearchTreeTest.java, v 0.1 15/12/2017 1:26 AM Exp $
 */

public class BinarySearchTreeTest {

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

    private BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    @BeforeEach
    public void init() {
        bst.add(15);
        bst.add(5);
        bst.add(16);
        bst.add(3);
        bst.add(12);
        bst.add(20);
        bst.add(10);
        bst.add(13);
        bst.add(18);
        bst.add(23);
        bst.add(6);
        bst.add(7);
        assertEquals(12, bst.size());
    }

    @Test
    public void testDelete() {
        assertEquals(15, (int) bst.remove(15));
        System.out.println(bst);
    }

    @Test
    public void testFindSuccessor() {
        Node<Integer> node = bst.search(16);
        assertEquals(16, (int) node.key);
        Node<Integer> successor = bst.findSuccessor(node);
        assertEquals(18, (int) successor.key);
    }

    @Test
    public void testFindMin() {
        Node<Integer> min = bst.getMin();
        assertEquals(3, (int) min.key);
    }

    @Test
    public void testFindMax() {
        Node<Integer> max = bst.getMax();
        assertEquals(23, (int) max.key);
    }

    @Test
    public void testValidate() {
        assertTrue(bst.validate());
    }

}