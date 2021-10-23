package com.baiyan.learn.math.leetcode;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * <href>
 *  https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/23
 */
public class Case167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] ints = new int[2];
        int left = 0;
        int right = numbers.length-1;
        if(numbers[left]>target){
            return ints;
        }
        while (left<right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                ints[0] = ++left;
                ints[1] = ++right;
                break;
            }else if(sum>target){
                right--;
            }else {
                left++;
            }
        }

        return ints;
    }


    public static void main(String[] args) {
        Case167 case167 = new Case167();
        Arrays.stream(case167.twoSum(new int[]{-1,0}, -1))
                .forEach(System.out::println);
    }

}
