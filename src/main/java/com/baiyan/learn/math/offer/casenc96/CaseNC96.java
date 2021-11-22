package com.baiyan.learn.math.offer.casenc96;

import java.util.Objects;
import java.util.Stack;

/**
 * NC96 判断一个链表是否为回文结构
 *
 * <href>
 *     https://www.nowcoder.com/practice/3fed228444e740c8be66232ce8b87c2f?tpId=117&&tqId=37813&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/22
 */
public class CaseNC96 {

    public boolean isPail (ListNode head) {
        ListNode start = head;
        Stack<Integer> stack = new Stack<>();
        while (start!=null){
            stack.add(start.val);
            start = start.next;
        }
        while (head!=null) {
            if (Objects.equals(stack.pop(), head.val)) {
                head = head.next;
            } else {
                return false;
            }

        }
        return true;
    }


}
