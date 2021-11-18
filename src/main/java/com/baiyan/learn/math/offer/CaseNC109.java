package com.baiyan.learn.math.offer;


/**
 * NC109 岛屿数量
 *
 * <href>
 *     https://www.nowcoder.com/practice/0c9664d1554e466aa107d899418e814e?tpId=117&&tqId=37833&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/18
 */
public class CaseNC109 {

    /**
     * 从碰到岛屿节点为1开始，连接起来的岛屿dfs
     * 遍历过后的节点置为0
     *
     * @param grid
     * @return
     */
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
        if(i<0 || j<0 || j>=grid[0].length || i>=grid.length || grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        if(i>0 && grid[i-1][j] =='1'){
            dfs(grid,i-1,j);
        }
        if(i<grid.length-1 && grid[i+1][j] =='1'){
            dfs(grid,i+1,j);
        }
        if(j>0 && grid[i][j-1] =='1'){
            dfs(grid,i,j-1);
        }
        if(i<grid[0].length-1 && grid[i][j+1] =='1'){
            dfs(grid,i,j+1);
        }
    }

}
