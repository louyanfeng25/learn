package com.baiyan.interview.math202202.node;

/**
 * BM14 链表的奇偶重排
 *
 * @author baiyan
 * @date 2022-02-25
 */
public class BM14 {

    public ListNode oddEvenList (ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return head;
        }
        //偶数头
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while (even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        //奇数尾与偶数头相连
        odd.next = evenHead;
        return head;
    }
}
