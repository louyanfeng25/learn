package com.baiyan.learn.math.offer.caseoffer06;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @author baiyan
 * @time 2021/6/7 17:21
 */
public class CaseOffer06 {
    int count = 0;

    /**
     * 链表翻转打印
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        head = reverse(head);
        int[] ints = new int[count];
        int circle = 0;
        while (head!=null){
            ints[circle] = head.val;
            head = head.next;
            circle++;
        }
        return ints;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode next ;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count++;
        }
        return pre;
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
        CaseOffer06 caseOffer06 = new CaseOffer06();
        caseOffer06.reversePrint(a);
    }

}
