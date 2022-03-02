package com.baiyan.interview.math202202.queueStack;

import java.util.ArrayList;

/**
 * BM45 滑动窗口的最大值
 *
 * @author baiyan
 * @date 2022-03-02
 */
public class BM45 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if(size==0 || num==null || num.length==0){
            return new ArrayList<>();
        }
        int start = 0;
        int end = size-1;
        ArrayList<Integer> result = new ArrayList<>();
        while(end < num.length) {
            result.add(getMax(num,start,end));
            start++;
            end++;
        }

        return result;
    }

    public int getMax(int[] num,int p1,int p2) {
        int max = -100001;
        for(int i = p1;i <= p2;i++) {
            max = Math.max(num[i],max);
        }
        return max;
    }

}
