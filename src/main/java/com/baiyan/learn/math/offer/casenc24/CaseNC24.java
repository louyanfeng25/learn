package com.baiyan.learn.math.offer.casenc24;

/**
 * NC24 删除有序链表中重复的元素-II
 *
 * <href>
 *     https://www.nowcoder.com/practice/71cef9f8b5564579bf7ed93fbe0b2024?tpId=117&&tqId=37729&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @date 2021/11/28
 */
public class CaseNC24 {

    public ListNode deleteDuplicates (ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(1001);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            //不相等的情况下，前置节点的地址先变更
            if(cur.val!=cur.next.val){
                pre = cur;
            }else {
                // 循环遍历，如果当前节点与后置节点的值一样，则将当前节点一直往后移动，
                // 直到最后一个重复节点
                while (cur.next!=null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                // 将前置节点的后置指向变更为最后一个重复节点的后置节点
                pre.next = cur.next;
            }
            //当前节点处理完成，往后移动
            cur = cur.next;
        }
        return dummy.next;
    }

}
