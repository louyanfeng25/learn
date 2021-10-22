package com.baiyan.learn.math.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 求众数 II
 *
 * <href>
 *  https://leetcode-cn.com/problems/majority-element-ii/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/22
 */
public class Case229 {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            Integer times = map.getOrDefault(num, 0);
            map.put(num,times+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        double rate = nums.length/3;
        map.forEach((key,value)->{
            if(value>rate){
                list.add(key);
            }
        });
        return list;
    }

    public static void main(String[] args) {
        Case229 case229 = new Case229();
        case229.majorityElement(new int[]{3,2,3}).forEach(System.out::println);
    }
}
