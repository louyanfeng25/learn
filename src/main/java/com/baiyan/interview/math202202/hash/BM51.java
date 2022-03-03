package com.baiyan.interview.math202202.hash;

import java.util.HashMap;

/**
 * BM51 数组中出现次数超过一半的数字
 *
 * @author baiyan
 * @date 2022-03-03
 */
public class BM51 {

    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>(50000);
        int half = array.length/2;
        for (int i : array) {
            Integer times = map.getOrDefault(i, 0);
            if(times+1>half){
                return i;
            }
            map.put(i,times+1);
        }
        return 0;
    }

}
