package com.baiyan.learn.math.leetcode;

/**
 *
 * 300. 最长递增子序列
 *
 * <href>
 *     https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * </href>
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 *
 * *****子序列的定义很重要*****
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 思路：
 * 动态规划题目
 * 规则转移方程：
 * dp[i] = 1,i=0;
 * dp[i] = max(dp(j)) ,0<=j<i && num[i]>num[j]
 *
 * @author baiyan
 * @time 2021/4/20 14:12
 */
public class Case300 {

    public int lengthOfLIS(int[] nums) {
        //长度为0单独处理
        if(nums.length==0){
            return 0;
        }
        //确定最长子序列边界范围
        int[] dp = new int[nums.length];
        //dp[0]为边界值，单独处理
        dp[0] = 1;
        int maxlength = 1;
        //dp[i]循环获取数组长度内最长的子序列
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            //dp[j]循环获取到下标i为止，能够出现的最长子序列
            for (int j = 0; j < i; j++) {
                //规则转移方程的判断条件
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxlength = Math.max(maxlength,dp[i]);
        }
        return maxlength;
    }

    public static void main(String[] args) {
        Case300 case300 = new Case300();
        System.out.println(case300.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(case300.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(case300.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
