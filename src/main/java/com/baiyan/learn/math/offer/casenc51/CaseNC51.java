package com.baiyan.learn.math.offer.casenc51;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * NC51 合并k个已排序的链表
 *
 * <href>
 *     https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6?tpId=117&&tqId=37747&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @date 2021/11/12
 */
public class CaseNC51 {

    /**
     * 优先级队列-堆的思想
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node:lists){
            if(node!=null){
                queue.add(node);
            }
        }
        ListNode h = new ListNode(-1);
        ListNode tail = h;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if(node!=null){
                ListNode next = node.next;
                tail.next = node;
                tail = node;
                if (next != null) {
                    queue.add(next);
                }
            }
        }
        return h.next;
    }
}
