package com.baiyan.interview.math202202.halfsearch;

/**
 * BM17 二分查找-I
 *
 * @author baiyan
 * @date 2022-02-25
 */
public class BM17 {

    public int search (int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }

}
