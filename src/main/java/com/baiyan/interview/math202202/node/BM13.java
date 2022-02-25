package com.baiyan.interview.math202202.node;

import java.util.Stack;

/**
 * BM13 判断一个链表是否为回文结构
 *
 * @author baiyan
 * @date 2022-02-25
 */
public class BM13 {

    public boolean isPail (ListNode head) {
        ListNode start = head;
        Stack<ListNode> stack = new Stack<>();
        while (start!=null){
            stack.add(start);
            start = start.next;
        }
        while (head!=null){
            ListNode pop = stack.pop();
            if(head.val!=pop.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
