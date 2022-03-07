package com.baiyan.interview.math202202.hash;

import java.util.HashSet;

/**
 * BM53 缺失的第一个正整数
 *
 * @author baiyan
 * @date 2022-03-07
 */
public class BM53 {

    public int minNumberDisappeared (int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int j = 1;
        while (set.contains(j)){
            j++;
        }
        return j;
    }
}
