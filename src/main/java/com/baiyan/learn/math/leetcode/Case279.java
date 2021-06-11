package com.baiyan.learn.math.leetcode;

/**
 *
 * 279. 完全平方数
 *
 * <href>
 *     https://leetcode-cn.com/problems/perfect-squares/
 * </href>
 *
 * @author baiyan
 * @time 2021/6/11 14:15
 */
public class Case279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i ; j++) {
                minCount = Math.min(minCount,dp[i-j*j]);
            }
            dp[i] = minCount +1;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Case279 case279 = new Case279();
        System.out.println(case279.numSquares(12));
    }
}
