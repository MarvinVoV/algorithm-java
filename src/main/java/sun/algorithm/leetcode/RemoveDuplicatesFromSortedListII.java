package sun.algorithm.leetcode;

import org.junit.Test;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * <p>
 * <p>
 * Reference: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/"> Remove Duplicates from Sorted List II</a>
 * Difficulty: Medium
 *
 * @author hufeng
 * @version RemoveDuplicatesFromSortedListII.java, v 0.1 17/11/2017 9:38 PM Exp $
 */

public class RemoveDuplicatesFromSortedListII {
    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
//                pre.next = cur.next; // distinct
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    @Test
    public void testNormalCase() {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        print(head);
        ListNode res = deleteDuplicates(head);
        print(res);
    }


}
