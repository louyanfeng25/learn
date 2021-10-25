package com.baiyan.learn.math.offer.case18;


import java.util.Objects;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author baiyan
 * @time 2021/10/25
 */
public class Case18 {

    public ListNode deleteNode(ListNode head, int val) {
        if(Objects.isNull(head)){
            return null;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode pre = first;
        ListNode current = head;
        while (Objects.nonNull(current.next)){
            if(current.val == val){
                break;
            }
            pre = current;
            current = current.next;
        }
        pre.next = pre.next.next;
        return first.next;

    }

    public static void main(String[] args) {
        ListNode last5 = new ListNode(5);
        ListNode last4 = new ListNode(4);
        ListNode last3 = new ListNode(3);
        ListNode last2 = new ListNode(2);
        ListNode last1 = new ListNode(1);
        last1.next=last2;
        last2.next=last3;
        last3.next=last4;
        last4.next=last5;
        Case18 case18 = new Case18();
       ListNode listNode = case18.deleteNode(last1, 1);
    }



}
