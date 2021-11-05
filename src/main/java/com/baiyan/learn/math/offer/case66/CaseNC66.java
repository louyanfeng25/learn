package com.baiyan.learn.math.offer.case66;


import java.util.HashSet;
import java.util.Set;

/**
 * NC66 两个链表的第一个公共结点
 *
 * <href>
 *     https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=117&&tqId=37761&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/05
 */
public class CaseNC66 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();
        while (pHead1!=null){
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2!=null){
            if (set.contains(pHead2)){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;

    }

}
