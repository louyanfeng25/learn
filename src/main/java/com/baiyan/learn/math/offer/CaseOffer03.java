package com.baiyan.learn.math.offer;

import java.util.HashMap;
import java.util.Objects;

/**
 * 数组重复数字
 *
 * @author baiyan
 * @time 2021/6/7 16:46
 */
public class CaseOffer03 {

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for(int num:nums){
            Integer integer = map.get(num);
            if(Objects.isNull(integer)){
                map.put(num,1);
            }else {
                return num;
            }
        }
        return 0;
    }

}
