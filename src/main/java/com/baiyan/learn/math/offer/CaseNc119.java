package com.baiyan.learn.math.offer;


import com.baiyan.learn.math.sort.QuickSort;

import java.util.ArrayList;

/**
 * NC119 最小的K个数
 *
 * <href>
 *     https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=117&&tqId=37765&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/01
 */
public class CaseNc119 {

    /**
     * 快排解决
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        QuickSort.quickSort(input,0,input.length-1);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

}
