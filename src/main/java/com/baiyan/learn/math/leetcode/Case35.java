package com.baiyan.learn.math.leetcode;

/**
 * 35. 搜索插入位置
 *
 * @date 2021/10/21
 * @author baiyan
 */
public class Case35 {

    public int searchInsert(int[] nums, int target) {
        return getMid(nums,target,0,nums.length-1);
    }

    public int getMid(int[] nums, int target,int start,int end){
        if(target > nums[end]){
            return end + 1;
        }
        if(target < nums[start]){
            return start -1 <=0 ? 0 : start-1;
        }
        if(target > nums[start] && target < nums[end] && end - start <=1){
            return start+1;
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
            if(target>=nums[mid-1] && target<=nums[mid]){
                return mid;
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
        Case35 case35 = new Case35();
        System.out.println(case35.searchInsert(new int[]{3,4,9,10},5));
    }
}
