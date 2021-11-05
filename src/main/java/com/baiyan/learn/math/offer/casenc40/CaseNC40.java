package com.baiyan.learn.math.offer.casenc40;


/**
 * NC40 两个链表生成相加链表
 *
 * <href>
 *     https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=117&&tqId=37814&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/05
 */
public class CaseNC40 {

    public ListNode addInList (ListNode head1, ListNode head2) {
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        head1 = reverse(head1);
        head2 = reverse(head2);
        int flag = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (head1!=null && head2!=null){
            int sum = head1.val + head2.val + flag;
            if(sum>=10){
                sum = sum-10;
                flag=1;
            }else {
                flag=0;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            head1=head1.next;
            head2=head2.next;
        }
        while (head1 != null) {
            int sum = head1.val+flag;
            if(sum>=10){
                sum = sum-10;
                flag=1;
            }else {
                flag=0;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            head1=head1.next;
        }
        while (head2 != null) {
            int sum = head2.val+flag;
            if(sum>=10){
                sum = sum-10;
                flag=1;
            }else {
                flag=0;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            head2=head2.next;
        }
        if(flag==1){
            temp.next = new ListNode(1);
        }
        ListNode reverse = reverse(result.next);
        return reverse;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        ListNode next;
        ListNode pre = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(9);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(7);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(6);
        ListNode e = new ListNode(3);
        d.next = e;

        ListNode listNode = new CaseNC40().addInList(a, d);
        System.out.println(listNode);
    }

}
