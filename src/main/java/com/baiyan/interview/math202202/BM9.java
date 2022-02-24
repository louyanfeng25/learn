package com.baiyan.interview.math202202;

/**
 * BM9 删除链表的倒数第n个节点
 *
 * @author baiyan
 * @date 2022-02-24
 */
public class BM9 {

    public ListNode removeNthFromEnd (ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

}
