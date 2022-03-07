package com.baiyan.interview.math202202.scanBackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * BM56 有重复项数字的全排列
 *
 * @author baiyan
 * @date 2022-03-07
 */
public class BM56 {

    ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        backTracking(num,new LinkedList<>(),new boolean[num.length]);
        return results;
    }


    public void backTracking(int[] num, LinkedList<Integer> list,boolean[] mark){
        if(list.size()==num.length){
            results.add(new ArrayList<>(list));
        }
        for (int i = 0; i < num.length; i++) {
            //1.被标记过的位子不进行遍历
            //2.如果当前位置与前置位置一样，并且前置位子没有被标记过，按照递归的顺序性看，前面必然
            //已经存在了一样序列的list，故跳过。
            if(mark[i] || i>0 && num[i] == num[i-1] && !mark[i-1]){
                continue;
            }
            list.add(num[i]);
            mark[i] = true;
            backTracking(num,list,mark);
            list.removeLast();
            mark[i]=false;
        }
    }

}
