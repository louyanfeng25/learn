package com.baiyan.learn.math.leetcode;

/**
 * 11. 盛最多水的容器
 * @author baiyan
 * @date 2021/09/29
 */
public class Case11 {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;

    }


}
