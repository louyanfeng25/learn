package com.baiyan.interview.math202202;

import java.util.ArrayList;
import java.util.Collections;

/**
 * BM12 单链表的排序
 *
 * @author baiyan
 * @date 2022-02-24
 */
public class BM12 {

    public ListNode sortInList (ListNode head) {
        ArrayList<Integer> arr=new ArrayList<>();
        while (head!=null){
            arr.add(head.val);
            head=head.next;
        }
        Collections.sort(arr);
        ListNode ans=new ListNode(0);
        ListNode cur=ans;
        for (int i=0;i<arr.size();i++){
            cur.next=new ListNode(arr.get(i));
            cur=cur.next;
        }
        return ans.next;
    }

}
