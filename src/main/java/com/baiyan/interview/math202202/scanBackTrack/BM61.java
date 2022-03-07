package com.baiyan.interview.math202202.scanBackTrack;

/**
 * BM61 矩阵最长递增路径
 *
 * @author baiyan
 * @date 2022-03-07
 */
public class BM61 {



    public int solve (int[][] matrix) {
        int maxCount = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxCount = Math.max(maxCount,backTracking(matrix,i,j,-1));
            }
        }
        return maxCount;
    }

    private int backTracking(int[][] matrix,int i,int j,int pre){
        if(matrix[i][j]<=pre){
            return 0;
        }
        int max = 0;
        if(i>0){
            max = Math.max(max,backTracking(matrix,i-1,j,matrix[i][j]));
        }
        if(i<matrix.length-1){
            max = Math.max(max,backTracking(matrix,i+1,j,matrix[i][j]));
        }
        if(j>0){
            max = Math.max(max,backTracking(matrix,i,j-1,matrix[i][j]));
        }
        if(j<matrix[0].length-1){
            max = Math.max(max,backTracking(matrix,i,j+1,matrix[i][j]));
        }
        return max+1;
    }

    public static void main(String[] args) {
        BM61 bm61 = new BM61();
        int a = bm61.solve(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(a);

    }

}
