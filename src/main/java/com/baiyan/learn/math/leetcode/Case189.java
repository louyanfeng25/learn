package com.baiyan.learn.math.leetcode;

import java.util.Arrays;

/**
 * 189. 旋转数组
 *
 * <href>
 *  https://leetcode-cn.com/problems/rotate-array/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/22
 */
public class Case189 {


    public void rotate(int[] nums, int k) {
        int move = k%nums.length;
        int[] newNumbers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNumbers[(i+move)%nums.length] = nums[i];
        }
        for (int i = 0; i < newNumbers.length; i++) {
            nums[i] = newNumbers[i];
        }
    }

    public static void main(String[] args) {
        Case189 case189 = new Case189();
        int[] ints = {-7, -3, 2, 3, 11};
        case189.rotate(ints,4);
        Arrays.stream(ints).forEach(System.out::println);
    }

}
