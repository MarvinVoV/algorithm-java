
package algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/">Remove Duplicates from Sorted List</a>
 *
 * @author hufeng
 * @version $Id: RemoveDuplicatesFromSortedList.java, v 0.1 2018年07月03日 下午5:29 hufeng Exp $
 */
public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
     *
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<>();
        occurred.add(head.val);
        ListNode pos = head;
        while (pos.next != null) {
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
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

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}