package com.baiyan.interview.math202202;

/**
 * BM6 判断链表中是否有环
 *
 * @author baiyan
 * @date 2022-02-24
 */
public class BM6 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

}
