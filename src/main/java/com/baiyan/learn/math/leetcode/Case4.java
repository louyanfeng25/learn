package com.baiyan.learn.math.leetcode;

/**
 * 寻找两个正序数组的中位数(4)
 *
 * <href>
 *     https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * </href>
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *  
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 *
 * 思路：存在暴力破解，时间复杂度与空间复杂度较高，直接合并数组排序取值
 *
 * @author baiyan
 * @time 2021/4/14 10:32
 */
public class Case4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLen = nums1.length;
        int bLen = nums2.length;
        int size = aLen + bLen;
        //偶数长度时需要左右两个数确定中位数
        int right = 0;
        int left = 0;
        //管理数组下表移动
        int aStart = 0;
        int bStart = 0;
        for (int i = 0; i <= size/2; i++) {
            //默认情况下移动right，left跟随，这一步关键
            left = right;
            //指针一边移动一边找出相对较大的数据，
            // 取出标准：
            // 1.数组未被用尽
            // 2.另外一个数组被用尽  或者   当前数组小于另一数组所在指针值
            if(aStart<aLen && (bStart>=bLen || nums1[aStart]<=nums2[bStart])){
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }
        //奇数取值
        if ((size %2) == 0){
            return (left + right) / 2.0;
            //偶数取值
        }else {
            return right;
        }
    }

    public static void main(String[] args) {
        Case4 case4 = new Case4();
        int[] ints = {1, 2, 5,6};
        int[] ints1 = {5,6,7};
        System.out.println(case4.findMedianSortedArrays(ints1,ints));
    }

}
