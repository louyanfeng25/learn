package com.baiyan.learn.math.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 27. 移除元素
 *
 * <href>
 *     https://leetcode-cn.com/problems/remove-element/
 * </href>
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author baiyan
 * @time 2021/4/19 10:07
 */
public class Case27 {


    public int removeElement(int[] nums, int val) {
        Map<Integer,Integer> equalValMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(Objects.equals(val,nums[i])){
                equalValMap.put(i,nums[i]);
            }
        }
        int restLength = nums.length - equalValMap.keySet().size();
        Map<Integer,Integer> notequalValMap = new HashMap<>(restLength);
        for(int i : equalValMap.keySet()){
            if(i<restLength){
                for (int j = restLength; j < nums.length; j++) {
                    if(!notequalValMap.containsKey(j) && !equalValMap.containsKey(j)){
                        nums[i] = nums[j];
                        notequalValMap.put(j,nums[j]);
                        break;
                    }
                }
            }
        }
        return restLength;
    }

    public static void main(String[] args) {
        Case27 case27 = new Case27();
        System.out.println(case27.removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }
}
