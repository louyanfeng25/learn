package com.baiyan.learn.math.leetcode;

/**
 *
 * 704. 二分查找
 *
 * <href>
 *  https://leetcode-cn.com/problems/binary-search/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/21
 */
public class Case704 {

    public int search(int[] nums, int target) {
        return getMid(nums,target,0,nums.length-1);
    }

    public int getMid(int[] nums, int target,int start,int end){
        if(target < nums[start] || target > nums[end] || start > end){
            return -1;
        }
        if(target == nums[start]){
            return start;
        }
        if(target == nums[end]){
            return end;
        }
        int sub = end + start + 1;
        if(sub%2 ==0){
            int mid = sub/2;
            if(target<=nums[mid-1]){
                return getMid(nums,target,start,mid-1);
            }
            if(target>=nums[mid]){
                return getMid(nums,target,mid,end);
            }
        }else{
            int mid = sub/2;
            if(target<=nums[mid]){
                return getMid(nums,target,start,mid);
            }
            if(target>=nums[mid]){
                return getMid(nums,target,mid,end);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Case704 case704 = new Case704();
        System.out.println("结果："+case704.search(new int[]{-1,0,3,5,9,12},2));
    }

}
