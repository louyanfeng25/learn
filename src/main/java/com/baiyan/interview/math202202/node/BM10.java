package com.baiyan.interview.math202202.node;

import java.util.HashMap;

/**
 * BM10 两个链表的第一个公共结点
 *
 * @author baiyan
 * @date 2022-02-24
 */
public class BM10 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode,Integer> map = new HashMap(8);
        while (pHead1!=null){
            map.put(pHead1,1);
            pHead1 = pHead1.next;
        }
        while (pHead2!=null){
            if(map.get(pHead2)!=null){
                return pHead2;
            }else {
                pHead2 = pHead2.next;
            }
        }
        return null;
    }


}
