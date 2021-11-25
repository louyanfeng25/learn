package com.baiyan.learn.math.offer.casenc21;

/**
 * NC21 链表内指定区间反转
 *
 * <href>
 *     https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=117&&tqId=37726&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @date 2021/11/25
 */
public class CaseNC21 {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        if(m==n || head==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int count = 1;
        while (count<m){
            pre = pre.next;
            count++;
        }
        ListNode cur = pre.next;
        ListNode temp;
        for (int i = m; i < n; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        CaseNC21 caseNC21 = new CaseNC21();
        ListNode listNode = caseNC21.reverseBetween(a, 2,4);
        System.out.println(listNode);
    }

}
