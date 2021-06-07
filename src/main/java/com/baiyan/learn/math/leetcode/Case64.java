package com.baiyan.learn.math.leetcode;

/**
 * 二维数组最小路径和
 *
 * <href>
 *     https://leetcode-cn.com/problems/minimum-path-sum/
 * </href>
 *
 * @author baiyan
 * @time 2021/5/16 21:50
 */
public class Case64 {

    public static void main(String[] args) {
        Case64 case64 = new Case64();
        int[][] grid = {{1,2,3},{4,5,6}};
        int i = case64.minPathSum(grid);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        //单行
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        //单列
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //多行多列
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }

}
