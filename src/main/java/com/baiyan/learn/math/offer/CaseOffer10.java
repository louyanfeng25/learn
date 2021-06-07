package com.baiyan.learn.math.offer;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 * @author baiyan
 * @time 2021/6/7 19:24
 */
public class CaseOffer10 {

    public int numWays(int n) {
        if(n==0){
            return 1%1000000007;
        }
        if(n==1){
            return 1%1000000007;
        }
        if(n==2){
            return 2%1000000007;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]%1000000007+dp[i-2]%1000000007;
        }
        return dp[n]%1000000007;
    }

    public static void main(String[] args) {
        CaseOffer10 caseOffer10 = new CaseOffer10();
        System.out.println(caseOffer10.numWays(7));
    }

}
