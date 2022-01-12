package com.baiyan.learn.math.offer;

import java.util.Arrays;

/**
 * NC156 数组中只出现一次的数（其它数出现k次）
 *
 * <href>
 * https://www.nowcoder.com/practice/5d3d74c3bf7f4e368e03096bb8857871?tpId=188&&tqId=38592&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D188%26page%3D1
 * </href>
 *
 * @author baiyan
 * @time 2022-01-12
 */
public class CaseNC156 {

    public int foundOnceNumber(int[] arr, int k) {
        //首先进行排序
        Arrays.sort(arr);
        //步长为i+k;
        for (int i = 0; i <= arr.length - 2; i = i + k) {
            //只要是不重复的，那么和相邻（和右边的数进行比较）的两个数一定不相等
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        //如果到倒数第二个数都没有找到，说明最后一个数就是不重复的那个数
        return arr[arr.length - 1];
    }
}
