package com.baiyan.learn.math.leetcode;

import java.util.Arrays;

/**
 * 1011.在 D 天内送达包裹的能力
 *
 * <href>
 *     https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * </href>
 *
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 *
 * 思路：
 *
 * 确定最大最小边界，然后根据二分法查找运载能力
 *
 * @author baiyan
 * @time 2021/4/26 10:11
 */
public class Case1011 {

    public int shipWithinDays(int[] weights, int D) {
        //最小值左边界【所有货物中最重的一个】
        int min = Arrays.stream(weights).max().getAsInt();
        //最大值有边界【所有货物重量之和】
        int max = Arrays.stream(weights).sum();
        while (min<max){
            int mid = (min+max)/2;
            // need 为需要运送的天数
            int need = 1;
            // cur 为当前这一天已经运送的包裹重量之和
            int cur = 0;
            for (int weight : weights) {
                //如果叠加包裹重量大于权重值，则天数加一，重量归0后重新加值
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                //逐步增加当天的重量
                cur = cur + weight;
            }
            //如果运送天数小于等于了规定的天数，则退出循环
            if (need <= D) {
                max = mid;
                //否则继续改变左侧最小值进行二分查找
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Case1011 case1011 = new Case1011();
        System.out.println(case1011.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
    }
}
