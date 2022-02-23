package com.baiyan.interview.math202202;

/**
 * BM2 链表内指定区间反转
 *
 * @author baiyan
 * @date 2022-02-23
 */
public class BM2 {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = head;
            head = head.next;
        }
        ListNode tmp = null;
        for (int i = m; i < n; i++) {
            tmp = head.next;
            head.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }


}
