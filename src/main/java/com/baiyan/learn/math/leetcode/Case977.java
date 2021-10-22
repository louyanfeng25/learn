package com.baiyan.learn.math.leetcode;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 *
 * <href>
 *     https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/22
 */
public class Case977 {


    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int rigtht = nums.length-1;
        int start = nums.length-1;
        int[] newNumbers = new int[nums.length];
        while (left <= rigtht){
            if(Math.pow(nums[rigtht],2) > Math.pow(nums[left],2)){
                newNumbers[start--] = (int) Math.pow(nums[rigtht],2);
                rigtht--;
            }else {
                newNumbers[start--] = (int) Math.pow(nums[left],2);
                left++;
            }
        }
        return newNumbers;
    }




    public static void main(String[] args) {
        Case977 case977 = new Case977();
        int[] ints = case977.sortedSquares(new int[]{-7,-3,2,3,11});
        Arrays.stream(ints).forEach(System.out::println);
    }
}
