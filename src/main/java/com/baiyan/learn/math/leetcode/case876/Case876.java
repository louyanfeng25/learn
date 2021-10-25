package com.baiyan.learn.math.leetcode.case876;


import java.util.Objects;

/**
 * 876. 链表的中间结点
 *
 * <href>
 *     https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/25
 */
public class Case876 {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (Objects.nonNull(fast.next)){
            slow = slow.next;
            fast = fast.next;
            if(Objects.nonNull(fast.next)){
                fast = fast.next;
            }
        }
        return slow;
    }

}
