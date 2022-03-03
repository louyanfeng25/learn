package com.baiyan.interview.math202202.hash;

import java.util.HashMap;

/**
 * BM52 数组中只出现一次的两个数字
 *
 * @author baiyan
 * @date 2022-03-03
 */
public class BM52 {

    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        // 用于返回结果
        int[] res = new int[2];
        // 创建一个哈希表
        HashMap<Integer,Object> set = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            // 如果已经被当作key了，那就直接remove掉
            if(set.containsKey(array[i])){
                set.remove(array[i],null);
            }else{
                // 否则就添加进去
                set.put(array[i],null);
            }
        }
        int i = 0;
        // 最后拿出来放进返回结果的数组中进行返回
        for(Integer num:set.keySet()){
            res[i++] = num;
        }
        return res;
    }

}
