package com.baiyan.learn.math.leetcode;

import java.util.Arrays;

/**
 * 517. 超级洗衣机
 *
 * <href>
 *  https://leetcode-cn.com/problems/super-washing-machines/
 * </href>
 *
 * @author baiyan
 * @date 2021/09/29
 */
public class Case517 {


    public int findMinMoves(int[] machines) {
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        if (tot % n != 0) {
            return -1;
        }
        int avg = tot / n;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num = num - avg;
            sum = sum + num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }

    public static void main(String[] args) {
        Case517 case517 = new Case517();
        System.out.println(case517.findMinMoves(new int[]{1,0,5}));
    }

}
