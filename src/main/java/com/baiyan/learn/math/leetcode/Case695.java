package com.baiyan.learn.math.leetcode;


/**
 * 695. 岛屿的最大面积
 *
 * <href>
 *     https://leetcode-cn.com/problems/max-area-of-island/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/27
 */
public class Case695 {

    /**
     * 从图上任意节点出发进行遍历，同一块区域因为被经历过之后会被置为0，则不会二次
     * 遍历，因此每块连续1区域只会遍历一次，只不过判断多次而已
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 ||
                x > grid.length-1 || y > grid[0].length-1 ||
                grid[x][y] != 1) {
            return 0;
        }
        //遍历过的节点置为0，放置重复遍历计数
        grid[x][y] = 0;
        int ans = 1;
        //上下左右扩散计算连续为1的数据
        ans = ans + dfs(grid,x-1,y);
        ans = ans + dfs(grid,x+1,y);
        ans = ans + dfs(grid,x,y-1);
        ans = ans + dfs(grid,x,y+1);
        return ans;
    }

    public static void main(String[] args) {
        Case695 case695 = new Case695();
        int[][] ints = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(case695.maxAreaOfIsland(ints));
    }

}
