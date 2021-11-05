package com.baiyan.learn.math.offer;


/**
 * NC22 合并两个有序的数组
 *
 * 归并排序思路，从右边开始放置数据，最右边开始放置最大的数据
 *
 * @author baiyan
 * @time 2021/11/05
 */
public class CaseNC22 {

    public void merge(int A[], int m, int B[], int n) {
        if(n==0){
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int cnt = m + n - 1;
        while(i >= 0 || j >= 0){
            if( (j < 0 || i >= 0 && A[i] >= B[j]) ){
                A[cnt--] = A[i--];
            }
            else {
                A[cnt--] = B[j--];
            }
        }
    }

    public static void main(String[] args) {
        CaseNC22 caseNC22 = new CaseNC22();
        int[] ints1 = {1,0};
        int[] ints2 = {2};
        caseNC22.merge(ints1,1,ints2,1);
        System.out.println(1);
    }

}
