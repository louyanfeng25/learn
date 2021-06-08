package com.baiyan.learn.math.leetcode;

import java.util.Objects;

/**
 * 322. 零钱兑换
 *
 * @author baiyan
 * @time 2021/6/8 13:52
 */
public class Case322 {

    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE-1;
            for(int coin:coins){
                if(i-coin<0){
                    continue;
                }
                dp[i] = Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return Objects.equals(dp[amount],Integer.MAX_VALUE-1) ? -1 :dp[amount];
    }

    public static void main(String[] args) {
        Case322 case322 = new Case322();
        System.out.println(case322.coinChange(new int[]{2},1));
    }
}
