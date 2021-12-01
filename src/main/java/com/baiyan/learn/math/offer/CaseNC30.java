package com.baiyan.learn.math.offer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * NC30 缺失的第一个正整数
 *
 * <href>
 *     https://www.nowcoder.com/practice/50ec6a5b0e4e45348544348278cdcee5?tpId=117&&tqId=37800&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/12/01
 */
public class CaseNC30 {


    public int minNumberDisappeared (int[] nums) {
        if(nums.length==0){
            return 1;
        }
        if(nums.length==1){
            if(nums[0]>=0){
                return nums[0]+1;
            }else {
                return 1;
            }
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(i==1 && nums[i-1]>1){
                return 1;
            }
            if(nums[i]>0 && nums[i-1]>=0 && nums[i]-nums[i-1]>=2){
                if(nums[i-1]>1){
                    return nums[i-1]+1;
                }
            }
            if(nums[i]>1 && nums[i-1]<0 ){
                return 1;
            }
        }
        if(nums[nums.length-1]>=0){
            return nums[nums.length-1]+1;
        }else {
            return 1;
        }
    }


    public int minNumberDisappeared1 (int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int j = 1;
        while (set.contains(j)){
            j++;
        }
        return j;
    }





    public static void main(String[] args) {
        CaseNC30 caseNC30 = new CaseNC30();
        System.out.println(caseNC30.minNumberDisappeared(new int[]{7,8,9,11,12}));
    }


}
