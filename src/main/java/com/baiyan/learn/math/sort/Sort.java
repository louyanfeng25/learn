package com.baiyan.learn.math.sort;

import java.util.Arrays;

/**
 * 奇数位递增偶数位递减的数组，排序
 *
 * @author baiyan
 * @time 2021/11/17
 */
public class Sort {

    public int[] sort(int[] nums){
        if(nums==null || nums.length==1){
            return nums;
        }
        int[] newInt1 = new int[nums.length];
        int[] newInt2 = new int[nums.length];
        int count1 = 0;
        int count2 = 0;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]%2==0){
                newInt1[count1++] = nums[i];
            }
        }
        for (int num : nums) {
            if (num % 2 == 1) {
                newInt2[count2++] = num;
            }
        }
        if(count2==0){
            return newInt1;
        }
        int i = count1-1;
        int j = count2-1;
        int end = nums.length-1;
        while (i>=0 || j>=0){
            if(j<0 || i>=0 && newInt1[i] > newInt2[j]){
                newInt1[end--] = newInt1[i--];
            }else {
                newInt1[end--] = newInt2[j--];
            }
        }
        return newInt1;
        /**
         * 暴力写法
         * while (l1<count1 && l2<count2){
         *             if(newInt1[l1]<newInt2[l2]){
         *                 nums[i++] = newInt1[l1];
         *                 l1++;
         *             }else {
         *                 nums[i++] = newInt2[l2];
         *                 l2++;
         *             }
         *         }
         *         if(l2<count2){
         *             for (int j = l2; j < count2; j++) {
         *                 nums[i++] = newInt2[l2];
         *             }
         *         }
         *         if(l1<count1){
         *             for (int j = l1; j < count1; j++) {
         *                 nums[i++] = newInt1[l1];
         *             }
         *         }
         */
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] ints = {1,3,5,7,9};
        int[] sort1 = sort.sort(ints);
        Arrays.stream(sort1).forEach(System.out::println);
    }
}
