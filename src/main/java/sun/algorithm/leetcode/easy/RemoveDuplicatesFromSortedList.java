
package sun.algorithm.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/">Remove Duplicates from Sorted List</a>
 *
 * @author hufeng
 * @version $Id: RemoveDuplicatesFromSortedList.java, v 0.1 2018年07月03日 下午5:29 hufeng Exp $
 */
public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            while (p.val == p.next.val) {
                p.next = p.next.next;
                if (p.next == null)
                    break;
            }

            if (p.next != null)
                p = p.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}