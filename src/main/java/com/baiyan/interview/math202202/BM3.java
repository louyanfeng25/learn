package com.baiyan.interview.math202202;

/**
 * BM3 链表中的节点每k个一组翻转
 *
 * @author baiyan
 * @date 2022-02-24
 */
public class BM3 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode countNode = head;
        int count = 0;
        while (countNode!=null){
            count++;
            countNode = countNode.next;
        }

        ListNode cur = head;
        ListNode pre = dummy;
        ListNode tmp = null;
        for (int i = 0; i < count/k; i++) {
            for (int j = 1; j < k; j++) {
                tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;

    }


}
