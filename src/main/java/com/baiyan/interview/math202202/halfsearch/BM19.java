package com.baiyan.interview.math202202.halfsearch;

/**
 * BM19 寻找峰值
 *
 * @author baiyan
 * @date 2022-02-25
 */
public class BM19 {

    public int findPeakElement (int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = (right+left)/2;
            //下降坡
            if(nums[mid] > nums[mid+1]){
                right = mid;
                //爬坡
            }else {
                left = mid+1;
            }
        }
        return left;
    }

}
