package com.baiyan.interview.math202202.queueStack;

/**
 * BM47 寻找第K大
 *
 * @author baiyan
 * @date 2022-03-02
 */
public class BM47 {


    /**
     * 快排解决
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public static int findKth(int[] a, int n, int K) {
        BM46 bm46 = new BM46();
        bm46.quickSort(a,0,n-1);
        return a[n-K];
    }

}
