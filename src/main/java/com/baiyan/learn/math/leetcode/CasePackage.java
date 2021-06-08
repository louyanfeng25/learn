package com.baiyan.learn.math.leetcode;

/**
 * 背包问题
 *
 * 背包问题概念转化：
 *  前i个物品在总重量不超过限制情况下最高总价值
 *  则状态转移方程为： max(前i-1个物品总重量不超过限制最高总量，前i-1个物品总重量不超过最高重量-第i个物品总量的价值)
 *
 * @author baiyan
 * @time 2021/6/8 16:35
 */
public class CasePackage {

    public int maxPackageValue(int maxWeight,int[] pac,int[] value){
        int[][] dp = new int[pac.length+1][maxWeight+1];
        for (int i = 1; i <= pac.length; i++) {
            for (int j = pac[i-1]; j <= maxWeight; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-pac[i-1]]+value[i-1]);
            }
        }
        return dp[pac.length][maxWeight];
    }

    public static void main(String[] args) {
        System.out.println(new CasePackage().maxPackageValue(3,new int[]{1,1,1},new int[]{4,2,3}));
    }

}
