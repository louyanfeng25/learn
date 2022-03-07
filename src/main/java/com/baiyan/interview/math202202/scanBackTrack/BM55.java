package com.baiyan.interview.math202202.scanBackTrack;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * BM55 没有重复项数字的全排列
 *
 * @author baiyan
 * @date 2022-03-07
 */
public class BM55 {

    ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        backTrack(num,new LinkedList<>());
        return results;
    }

    public void backTrack(int[] num, LinkedList<Integer> list){
        if(list.size() == num.length){
            results.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            //标记当前元素是否已经去取用过
            if(list.contains(num[i])){
                continue;
            }
            list.add(num[i]);
            //继续下钻
            backTrack(num,list);
            //回溯移除最后一位
            list.removeLast();
        }
    }

}
