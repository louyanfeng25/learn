package com.baiyan.learn.math.leetcode;

import java.util.Arrays;

/**
 * 283. 移动零
 *
 * 双指针，左指针左边均为大于0的数字，右指针和右边均为小于0的数字
 *
 * <href>
 *     https://leetcode-cn.com/problems/move-zeroes/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/23
 */
public class Case283 {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if(nums[right]!=0){
                int swap = nums[right];
                nums[right] = nums[left];
                nums[left] = swap;
                right++;
                left++;
            }else {
                right++;
            }
        }
    }

    public static void main(String[] args) {
        Case283 case283 = new Case283();
        int[] ints = {73348,66106,-85359,53996,18849,-6590,-53381,-86613,-41065,83457,0};
        case283.moveZeroes(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
