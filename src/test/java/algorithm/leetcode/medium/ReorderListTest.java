package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static algorithm.leetcode.medium.ReorderList.print;
import static algorithm.leetcode.medium.ReorderList.reorderList;

class ReorderListTest {

    @Test
    public void testNormalCase() {
        ReorderList.ListNode a = new ReorderList.ListNode(1);
        ReorderList.ListNode b = new ReorderList.ListNode(2);
        ReorderList.ListNode c = new ReorderList.ListNode(3);
        ReorderList.ListNode d = new ReorderList.ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;

        reorderList(a);
        print(a);

    }

}