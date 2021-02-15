package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static algorithm.leetcode.medium.RemoveDuplicatesFromSortedListII.deleteDuplicates;
import static algorithm.leetcode.medium.RemoveDuplicatesFromSortedListII.print;

class RemoveDuplicatesFromSortedListIITest {

    @Test
    public void testNormalCase() {
        RemoveDuplicatesFromSortedListII.ListNode head = new RemoveDuplicatesFromSortedListII.ListNode(1);
        RemoveDuplicatesFromSortedListII.ListNode a = new RemoveDuplicatesFromSortedListII.ListNode(2);
        RemoveDuplicatesFromSortedListII.ListNode b = new RemoveDuplicatesFromSortedListII.ListNode(3);
        RemoveDuplicatesFromSortedListII.ListNode c = new RemoveDuplicatesFromSortedListII.ListNode(3);
        RemoveDuplicatesFromSortedListII.ListNode d = new RemoveDuplicatesFromSortedListII.ListNode(4);
        RemoveDuplicatesFromSortedListII.ListNode e = new RemoveDuplicatesFromSortedListII.ListNode(4);
        RemoveDuplicatesFromSortedListII.ListNode f = new RemoveDuplicatesFromSortedListII.ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        print(head);
        RemoveDuplicatesFromSortedListII.ListNode res = deleteDuplicates(head);
        print(res);
    }

}