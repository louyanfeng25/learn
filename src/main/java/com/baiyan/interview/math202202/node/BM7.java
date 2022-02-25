package com.baiyan.interview.math202202.node;

import java.util.HashMap;

/**
 * BM7 链表中环的入口结点
 *
 * @author baiyan
 * @date 2022-02-24
 */
public class BM7 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashMap<ListNode, Integer> map = new HashMap<>(8);
        while (pHead!=null){
            Integer exist = map.get(pHead);
            if(exist!=null){
                return pHead;
            }
            map.put(pHead,1);
            pHead = pHead.next;
        }
        return null;
    }
}
