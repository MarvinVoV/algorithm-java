package algorithm.leetcode.domain;

/**
 * @author marvin
 * @version ListNode.java, v 0.1 2022/05/21 18:29 Exp $
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
