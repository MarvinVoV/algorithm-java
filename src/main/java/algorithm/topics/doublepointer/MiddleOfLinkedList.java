package algorithm.topics.doublepointer;

import algorithm.leetcode.domain.ListNode;

/**
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list">Middle Of the LinkedList</a>
 *
 * @author marvin
 * @version MiddleOfLinkedList.java, v 0.1 2022/05/21 17:41 Exp $
 */
public class MiddleOfLinkedList {

    /**
     * 使用快慢指针的思路
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        int count = 0;
        while (fast.next != null) {
            fast = fast.next;
            count++;
            if (count % 2 == 0) {
                slow = slow.next;
            }

        }
        return count % 2 == 0 ? slow : slow.next;
    }

    /**
     * 优化代码: slow一次走一步, fast一次走两步，当fast到达链表结尾时，slow必然位于中间
     *
     * @param head
     * @return
     */
    public ListNode middelNode2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}

