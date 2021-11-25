package com.baiyan.learn.math.offer;


/**
 * NC34 求路径
 *
 * <href>
 *     https://www.nowcoder.com/practice/166eaff8439d4cd898e3ba933fbc6358?tpId=117&&tqId=37736&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/25
 */
public class CaseNC34 {

    public int uniquePaths (int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new CaseNC34().uniquePaths(2,1));
    }

}
