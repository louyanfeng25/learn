package com.baiyan.interview.math202202.scanBackTrack;

/**
 * BM57 岛屿数量
 *
 * @author baiyan
 * @date 2022-03-07
 */
public class BM57 {


    public int solve (char[][] grid) {
        if(grid==null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,int i,int j){
        //这行判断条件可以直接去除
        if(i<0 || j<0 || j==grid[0].length || i== grid.length || grid[i][j] == '0'){
            return;
        }
        grid[i][j]='0';
        if(i>0 && grid[i-1][j]=='1'){
            dfs(grid,i-1,j);
        }
        if(i<grid.length-1 && grid[i+1][j]=='1'){
            dfs(grid,i+1,j);
        }
        if(j>0 && grid[i][j-1]=='1'){
            dfs(grid,i,j-1);
        }
        if(j<grid[0].length-1 && grid[i][j+1]=='1'){
            dfs(grid,i,j+1);
        }
    }


}
