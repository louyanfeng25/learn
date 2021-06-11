package com.baiyan.learn.math.leetcode;

/**
 * 62. 不同路径
 *
 * <href>
 *      https://leetcode-cn.com/problems/unique-paths/
 * </href>
 *
 * @author baiyan
 * @time 2021/6/11 15:21
 */
public class Case62 {

    public int uniquePaths(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Case62 case62 = new Case62();
        System.out.println(case62.uniquePaths(3,7));
    }

}
