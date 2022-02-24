package com.baiyan.interview.math202202;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * BM5 合并k个已排序的链表
 *
 * @author baiyan
 * @date 2022-02-24
 */
public class BM5 {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));

        for (ListNode list : lists) {
            if(list!=null){
                queue.add(list);
            }
        }

        ListNode pre = new ListNode(-1);
        ListNode dummy = pre;
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            if(poll!=null){
                dummy.next = poll;
                dummy = dummy.next;
                poll = poll.next;
                if(poll!=null){
                    queue.add(poll);
                }
            }
        }
        return pre.next;
    }
}
