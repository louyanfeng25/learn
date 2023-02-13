package com.baiyan.interview.math202202.node;

/**
 * BM15 删除有序链表中重复的元素-I
 *
 * @author baiyan
 * @date 2022-02-25
 */
public class BM15 {

    public ListNode deleteDuplicates (ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur!=null){
           if(cur.val==pre.val){
               cur=cur.next;
               pre.next = cur;
           }else {
               pre = cur;
               cur = cur.next;
           }
        }
        return head;
    }
}
