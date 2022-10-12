package algorithm.topics.linkedlist;

import algorithm.leetcode.domain.ListNode;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/linked-list-components/solution/lian-biao-zu-jian-by-leetcode-solution-5f91>Linked List Components</a>
 *
 * @author marvin
 * @version LinkedListComponent.java, v 0.1 2022/10/12 22:52 Exp $
 */
public class LinkedListComponent {
    /**
     * 此题需要计算组件的个数，只需在链表中计算有多少组件的起始位置即可。当一个节点满足以下条件之一时，它是组件的起始位置：
     * <p>
     * 节点的值在数组 nums 中且节点位于链表起始位置；
     * 节点的值在数组 nums 中且节点的前一个点不在数组 * nums 中。
     * 遍历链表，计算出满足条件的点的个数即可。因为需要多次判断值是否位于数组 nums 中，用一个哈希集合保存数组 nums 中的点可以降低时间复杂度。
     * <p>
     *
     * @param head
     * @param nums
     * @return
     */
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num : nums) {
            numsSet.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null) {
            if (numsSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    res++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;

    }
}
