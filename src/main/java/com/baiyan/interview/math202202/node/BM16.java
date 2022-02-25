package com.baiyan.interview.math202202.node;

/**
 * BM16 删除有序链表中重复的元素-II
 *
 * @author baiyan
 * @date 2022-02-25
 */
public class BM16 {

    public ListNode deleteDuplicates (ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            if(cur.val != cur.next.val){
                pre = cur;
            }else {
                while (cur.next!=null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

}
