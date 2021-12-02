package com.baiyan.learn.math.offer.casenc133;


/**
 * NC133 链表的奇偶重排
 *
 * <href>
 *     https://www.nowcoder.com/practice/02bf49ea45cd486daa031614f9bd6fc3?tpId=117&&tqId=37845&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/12/02
 */
public class CaseNC133 {

    public ListNode oddEvenList (ListNode head) {
        if(head==null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode cur = head;
        ListNode pre = cur;
        while (cur!=null){
            temp.next = cur.next;
            temp = temp.next;
            if(cur.next!=null){
                cur.next = cur.next.next;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = dummy.next;
        return head;
    }

    public static void main(String[] args) {
        CaseNC133 caseNC133 = new CaseNC133();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(7);
        ListNode listNode6 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = caseNC133.oddEvenList(listNode1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
