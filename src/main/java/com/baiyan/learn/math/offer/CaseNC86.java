package com.baiyan.learn.math.offer;

/**
 * NC86 矩阵元素查找
 *
 * <href>
 *     https://www.nowcoder.com/practice/3afe6fabdb2c46ed98f06cfd9a20f2ce?tpId=117&&tqId=37788&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/30
 */
public class CaseNC86 {

    /**
     * 右上角开始
     *
     * 值比X小则行+1，值比X大，则列-1
     *
     * @param mat
     * @param n
     * @param m
     * @param x
     * @return
     */
    public int[] findElement(int[][] mat, int n, int m, int x) {
        int maxN = n;
        n = 0;
        m = m-1;
        while (n<maxN && m>=0){
            if(mat[n][m] == x){
                return new int[]{n,m};
            }
            if(mat[n][m] > x){
                m--;
            }
            if(mat[n][m] < x){
                n++;
            }
        }
        return new int[]{};
    }

}
