package com.baiyan.learn.math;

import java.util.Objects;

/**
 * 28. 实现 strStr()
 *
 * <href>
 *     https://leetcode-cn.com/problems/implement-strstr/
 * </href>
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *
 * @author baiyan
 * @time 2021/4/20 09:14
 */
public class Case28 {

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        if(!haystack.contains(needle)){
            return -1;
        }
        int minIndex = Integer.MAX_VALUE;
        int startHayStack = 0;
        int endHayStack = 0;
        for (; startHayStack < haystack.length(); startHayStack++) {
            for(;endHayStack < haystack.length();endHayStack++){
                String substring = haystack.substring(startHayStack, endHayStack+1);
                if(needle.startsWith(substring)){
                    if(Objects.equals(substring,needle)){
                        minIndex = Math.min(startHayStack,minIndex);
                    }
                }else {
                    break;
                }
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Case28 case28 = new Case28();
        System.out.println("aa".substring(0,1));
        System.out.println(case28.strStr("hello","ll"));
        System.out.println(case28.strStr("aaaaa","bba"));
        System.out.println(case28.strStr("",""));
    }
}
