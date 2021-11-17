package com.baiyan.learn.math.offer;

/**
 * NC128 接雨水问题
 *
 * <href>
 *     https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f?tpId=117&&tqId=37802&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/17
 */
public class CaseNC128 {

    /**
     * 双指针思路
     *
     * 数组的所有数字和表示容器的大小
     * 左右边界限制了容器所能容纳的水的大小，短板原则。
     *
     * 左指针跟右指针从两边分别合并过来
     * 如果左指针比右指针要矮，从左边开始遍历，短板原则
     * 左移过程中比arr[++l]<arr[l],表示能够容纳雨水，雨水总量加上差值
     * 碰到arr[++l]>=arr[l],表示无法再继续容纳雨水了，再次跟右指针比较
     * 取小的一边开始移动，同理进行叠加
     * 直到左右指针相碰
     *
     * @param arr
     * @return
     */
    public long maxWater (int[] arr) {
        if(arr==null || arr.length<3){
            return 0;
        }
        int left = 0;
        int right = arr.length-1;
        int min = Math.min(arr[left],arr[right]);
        int area = 0;
        while (left<right){
            if(arr[left]<arr[right]){
                left ++;
                if(arr[left]<min){
                    area = area + min - arr[left];
                }else {
                    min = Math.min(arr[left],arr[right]);
                }
            }else {
                right--;
                if (arr[right]<min){
                    area = area + min - arr[right];
                }else {
                    min = Math.min(arr[left],arr[right]);
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        CaseNC128 caseNC128 = new CaseNC128();
        System.out.println(caseNC128.maxWater(new int[]{3,1,2,5,2,4}));
    }

}
