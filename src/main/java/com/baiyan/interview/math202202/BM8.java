package com.baiyan.interview.math202202;

/**
 * BM8 链表中倒数最后k个结点
 *
 * @author baiyan
 * @date 2022-02-24
 */
public class BM8 {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        if(pHead == null){
            return pHead;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        int i = 0;
        for (; fast!=null && i < k; i++) {
            fast = fast.next;
        }
        if(i<k){
            return null;
        }
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
