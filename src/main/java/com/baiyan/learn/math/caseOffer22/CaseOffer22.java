package com.baiyan.learn.math.caseOffer22;

import java.util.Objects;

/**
 * 倒数K个节点
 *
 * 思路：
 *
 * 倒数K个，就是正数L-K+1个数，那么使用双指针，node1指针跑到k-1个节点时，剩下步长为l-k+1个
 * 此时node2开始跑，当node1跑到null时，这个时候node2正好处于倒数第K个
 *
 * @author baiyan
 * @time 2021/5/10 21:09
 */
public class CaseOffer22 {

    public ListNode solution(ListNode head,int k){
        ListNode node1,node2;
        if(k<0 || Objects.isNull(head)){
            return null;
        }
        //初始化是node1跟node2都指向head节点
        node1 = node2 = head;
        //记录整体链表的长度用于比较K的步长是否合理话
        int count = 0;
        //计入K的步长
        int index = k;
        //node1开始跑
        while (Objects.nonNull(node1)){
            node1 = node1.next;
            count++;
            //当k小于1时候，
            if(k<1){
                node2 = node2.next;
            }
            k--;
        }
        //节点个数小于K的步长，那就返回null
        if(count<index){
            return null;
        }
        return node2;
    }
}
