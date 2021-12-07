package com.baiyan.learn.math.offer;

import java.util.Arrays;

/**
 * NC18 顺时针旋转矩阵
 *
 * <href>
 *     https://www.nowcoder.com/practice/2e95333fbdd4451395066957e24909cc?tpId=117&&tqId=37790&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/12/07
 */
public class CaseNc18 {


    public int[][] rotateMatrix(int[][] mat, int n) {
        //先按主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        //再左右翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = mat[i][n-1-j];
                mat[i][n-1-j] = mat[i][j];
                mat[i][j] = temp;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        CaseNc18 caseNc18 = new CaseNc18();
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] ints = caseNc18.rotateMatrix(mat, 3);
        Arrays.stream(ints).forEach(e-> Arrays.stream(e).forEach(System.out::println));
    }

}


