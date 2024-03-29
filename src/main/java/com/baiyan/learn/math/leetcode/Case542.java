package com.baiyan.learn.math.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 *
 * <href>
 *     https://leetcode-cn.com/problems/01-matrix/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/29
 */
public class Case542 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 先进行0节点的数据标记，然后将0四周的节点标位1的举例，然后再广度遍历扩散
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] ints ={{1,1,1},{1,1,1},{0,1,1}};
        Case542 case542 = new Case542();
        int[][] ints1 = case542.updateMatrix(ints);
        System.out.println(ints1);
    }




}
