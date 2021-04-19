package com.baiyan.learn.math.case2;

import java.util.Objects;

/**
 * 两数相加(2)
 *
 * <href>
 *     https://leetcode-cn.com/problems/add-two-numbers/
 * </href>
 * 思路：长短链表补位，不可直接数组相加
 *
 * @author baiyan
 * @time 2021/04/13
 */
public class Case2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode other = root;
        boolean carry = false;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)){
            int l1Value = Objects.isNull(l1) ? 0 : l1.val;
            int l2Value = Objects.isNull(l2) ? 0 : l2.val;
            int sum = (carry? 1:0) + l1Value +l2Value;
            carry = sum >= 10;
            ListNode temp = new ListNode(sum%10,null);
            other.next = temp;
            other = temp;
            l1 = Objects.isNull(l1) ? null : l1.next;
            l2 = Objects.isNull(l2) ? null : l2.next;
        }
        if(carry){
            other.next = new ListNode(1,null);
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(4,node3);
        ListNode node1 = new ListNode(2,node2);


        ListNode node6 = new ListNode(8,null);
        ListNode node5 = new ListNode(6,node6);
        ListNode node4 = new ListNode(5,node5);
        Case2 case2 = new Case2();
        case2.addTwoNumbers(node1,node4);
    }
}
