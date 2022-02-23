package com.baiyan.interview.math202202;

/**
 * BM1 反转链表
 *
 * @author baiyan
 * @date 2022-02-23
 */
public class BM1 {

    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
