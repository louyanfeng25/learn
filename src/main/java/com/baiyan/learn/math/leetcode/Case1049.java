package com.baiyan.learn.math.leetcode;

/**
 *
 * 1049. 最后一块石头的重量 II
 *
 * 背包问题的变形
 *
 * @author baiyan
 * @time 2021/6/8 14:25
 */
public class Case1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum = sum + stone;
        }
        int t = sum / 2;
        //前i个石头中不超过t的最大值数组
        int[][] dp = new int[stones.length+1][t + 1];
        for (int i = 1 ; i <= stones.length ; i++) {
            for (int j = stones[i-1]; j <= t; j++) {
                // 前i个石头中不超过t的最大值数组取：
                // 前i-1个石头中不超过t的最大值数组
                // 或者
                // 前i-1个是否中不超过t-stone[i-1]的数据
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - stones[i-1]]+ stones[i-1]);
            }
        }
        return Math.abs(sum - dp[stones.length][t] - dp[stones.length][t]);
    }

    public static void main(String[] args) {
        Case1049 case1049 = new Case1049();
        //2,7,4,1,8,1
        //[1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98]
        System.out.println(case1049.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }
}
