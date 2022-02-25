package com.baiyan.interview.math202202.node;

/**
 * BM4 合并两个排序的链表
 *
 * @author baiyan
 * @date 2022-02-24
 */
public class BM4 {

    public ListNode Merge(ListNode l1,ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode dummy = pre;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if(l1!=null){
            dummy.next = l1;
        }
        if(l2!=null){
            dummy.next = l2;
        }
        return pre.next;
    }

}
