package com.baiyan.learn.math.offer;

/**
 * NC32 求平方根
 *
 * <href>
 *     https://www.nowcoder.com/practice/09fbfb16140b40499951f55113f2166c?tpId=117&&tqId=37734&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/10
 */
public class Case32 {

    /**
     * 根据平方数的性质——连续n个奇数相加的结果一定是平方数。
     * 如：9=1+3+5；
     * 16=1+3+5+7；
     *
     * @param x
     * @return
     */
    public int sqrt1 (int x) {
        int i = 1;
        int res = 0;
        while (x >= 0) {
            x -= i;
            res++;
            i += 2;
        }
        return res - 1;
    }

    /**
     * 二分法
     *
     * @param x
     * @return
     */
    public int sqrt2 (int x) {
        if (x < 2){
            return x;
        }
        //右端从x/2开始
        int left = 1, right = x / 2;
        int mid;
        int lastMid = 0;
        while (left <= right) {
            //不用x > mid * mid 会溢出
            mid = left + (right - left) / 2;
            if (x / mid > mid) {
                left = mid + 1;
                //向下取整
                lastMid = mid;
            }
            else if (x / mid < mid){
                right = mid - 1;
            } else{
                return mid;
            }
        }
        return lastMid;
    }
}
