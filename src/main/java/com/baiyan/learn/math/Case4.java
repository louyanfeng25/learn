package com.baiyan.learn.math;

/**
 * 寻找两个正序数组的中位数(4)
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
        int right = 0;
        int left = 0;
        int aStart = 0;
        int bStart = 0;
        for (int i = 0; i <= size/2; i++) {
            left = right;
            if(aStart<aLen && (bStart>=bLen || nums1[aStart]<=nums2[bStart])){
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }
        if ((size %2) == 0){
            return (left + right) / 2.0;
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
