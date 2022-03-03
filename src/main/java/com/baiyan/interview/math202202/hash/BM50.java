package com.baiyan.interview.math202202.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * BM50 两数之和
 *
 * @author baiyan
 * @date 2022-03-03
 */
public class BM50 {

    public int[] twoSum (int[] numbers, int target) {
        Map<Integer,Integer>  map = new HashMap<>(8);
        for (int i = 0; i < numbers.length; i++) {
            Integer integer = map.get(target - numbers[i]);
            if(integer!=null){
                return i<integer ? new int[]{i+1,integer+1} : new int[]{integer+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return new int[]{};
    }

}
