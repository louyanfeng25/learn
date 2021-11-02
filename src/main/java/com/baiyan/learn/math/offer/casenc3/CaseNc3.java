package com.baiyan.learn.math.offer.casenc3;

import java.util.HashMap;
import java.util.Objects;

/**
 * NC3 链表中环的入口结点
 *
 * <href>
 *     https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=117&&tqId=37713&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/02
 */
public class CaseNc3 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashMap<ListNode,Integer> exist = new HashMap<>();
        while (pHead!=null){
            if(Objects.isNull(exist.get(pHead))){
                exist.put(pHead,1);
                pHead = pHead.next;
            }else {
                break;
            }
        }
        return pHead;
    }
}
