package com.baiyan.learn.math.offer.casenc50;


/**
 * NC50 链表中的节点每k个一组翻转
 *
 * @author baiyan
 * @date 2021/11/01
 */
public class CaseNc50 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, temp;
        int len = 0;
        while (head != null) {
            len ++ ;
            head = head.next;
        }
        for (int i = 0; i < len/k; i++) {
            for (int j = 1; j < k; j ++ ) {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        CaseNc50 caseNc50 = new CaseNc50();
        ListNode listNode = caseNc50.reverseKGroup(a, 3);
        System.out.println(listNode);
    }
}
