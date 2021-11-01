package com.baiyan.learn.math.offer.casenc4;


/**
 * 判断链表中是否有环
 *
 * 思路1：快慢指针
 * 思路2：map记录走过的节点
 *
 * <href>
 *     https://leetcode-cn.com/problems/lru-cache/
 * </href>
 *
 * @author baiyan
 * @date 2021/11/01
 */
public class CaseNC4 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow ==fast){
                return true;
            }
        }
        return false;
    }

}
