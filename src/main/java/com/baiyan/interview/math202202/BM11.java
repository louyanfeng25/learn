package com.baiyan.interview.math202202;

/**
 * BM11 两个链表生成相加链表
 *
 * @author baiyan
 * @date 2022-02-24
 */
public class BM11 {

    public ListNode addInList (ListNode head1, ListNode head2) {

        if(head1==null){
            return head2;
        }

        if(head2==null){
            return head1;
        }

        ListNode head1Reverse = BM1.ReverseList(head1);
        ListNode head2Reverse = BM1.ReverseList(head2);
        ListNode dummy = new ListNode(-1);
        ListNode count = dummy;
        int flag = 0;
        while (head1Reverse!=null || head2Reverse!=null){
            int head1Value = head1Reverse!=null ? head1Reverse.val : 0;
            int head2Value = head2Reverse!=null ? head2Reverse.val : 0;
            int sum = head1Value + head2Value+flag;
            if(sum>=10){
               sum = sum - 10;
               flag = 1;
            }else {
               flag = 0;
            }
            ListNode node = new ListNode(sum);
            count.next = node;
            count = count.next;
            head1Reverse = head1Reverse!=null ? head1Reverse.next : null;
            head2Reverse = head2Reverse!=null ? head2Reverse.next : null;
        }
        if(flag==1){
            count.next = new ListNode(1);
        }
        return BM1.ReverseList(dummy.next);

    }

}
