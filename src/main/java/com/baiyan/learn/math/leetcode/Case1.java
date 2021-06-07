package com.baiyan.learn.math.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 两数之和(1)
 *
 *  <href>
 *      https://leetcode-cn.com/problems/two-sum/
 *  </href>
 * 思路：备忘录模式，map缓存已经比较过的数据，然后取值比较
 *
 * @author baiyan
 * @time 2021/04/13
 */
public class Case1 {

    public int[] twoSum(int[] nums, int target) {
        if(Objects.isNull(nums) || Objects.equals(nums.length,0)){
            throw new RuntimeException("数组入参异常");
        }
        Map<Integer, Integer> map = new HashMap(8);
        for (int i = 0; i < nums.length; i++) {
            if(Objects.nonNull(map.get(target-nums[i]))){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        throw new RuntimeException("不存在两数之和");
    }

    public static void main(String[] args) {
        Case1 case1 = new Case1();
        int[] ints = {1, 2, 3, 4, 5};
        int target = 5;
        int[] result = case1.twoSum(ints, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
