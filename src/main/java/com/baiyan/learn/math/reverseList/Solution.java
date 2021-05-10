package com.baiyan.learn.math.reverseList;

/**
 * 链表翻转
 *
 * @author baiyan
 * @time 2021/5/9 22:27
 */
public class Solution {

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
        new Solution().ReverseList(a);
        while (e != null) {
            System.out.println(e.val);
            e = e.next;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            //保存下一个head的指针
            next = head.next;
            //将头结点的指针置为pre
            head.next = pre;
            //一轮循环结束前置节点变成head
            pre = head;
            //后续节点变成了头
            head = next;
        }
        return pre;
    }
}
