package com.baiyan.learn.math.leetcode.case21;


/**
 * 21. 合并两个有序链表
 *
 * <href>
 *     https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * </href>
 *
 * @author baiyan
 * @date 2021/11/01
 */
public class Case21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}