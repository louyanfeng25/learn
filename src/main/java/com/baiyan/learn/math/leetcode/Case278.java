package com.baiyan.learn.math.leetcode;

/**
 * 278. 第一个错误的版本
 *
 * <href>
 *  https://leetcode-cn.com/problems/first-bad-version/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/21
 */
public class Case278 {

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int bad){

        return bad >= 4 ;
    }

    public static void main(String[] args) {
        Case278 case278 = new Case278();
        System.out.println(case278.firstBadVersion(5));
    }
}
