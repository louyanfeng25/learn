package com.baiyan.learn.math.leetcode.case19;


import java.util.Objects;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * <href>
 *     https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/25
 */
public class Case19 {

    /**
     * 先计算长度再进行拼接，最优应该使用快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(Objects.isNull(head)){
            return null;
        }
        int length = 1;
        ListNode countNode = head;
        while (Objects.nonNull(countNode.next)){
            length ++;
            countNode = countNode.next;
        }
        ListNode result = new ListNode(0,head);
        ListNode temp = result;
        for (int i = 1; i < length - n + 1; ++i) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return result.next;
    }

    /**
     * 双指针做法
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static void main(String[] args) {
        ListNode last4 = new ListNode(5,null);
        ListNode last3 = new ListNode(4,last4);
        ListNode last2 = new ListNode(3,last3);
        ListNode last1 = new ListNode(2,last2);
        ListNode head = new ListNode(1,last1);
        Case19 case19 = new Case19();
        ListNode listNode = case19.removeNthFromEnd(head, 2);
    }
}
