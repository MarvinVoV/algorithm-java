package algorithm.topics.doublepointer;

import algorithm.leetcode.domain.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">Remove Nth Node From End of List</a>
 *
 * @author marvin
 * @version RemoveNthNodeFromEndOfList.java, v 0.1 2022/05/21 18:28 Exp $
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * 快慢指针思路:
     * 1. 初始时，fast指针前进n次，使得slow和fast之间间隔n-1个节点，即fast比slow超前了n个节点
     * 2. 在这之后，slow和fast同时进行遍历，当fast到链表末尾，slow恰好指向倒数第n个节点
     * 3. 因为要做删除操作，这里可以在初始时将slow节点指向哑节点(dummy node)，这样方便删除
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head, slow = dummy;
        // 初始
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
