package com.baiyan.learn.math.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 无重复字符的最长子串(3)
 *
 * <href>
 *     https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * </href>
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 思路：
 *
 * @author baiyan
 * @time 2021/4/14 09:27
 */
public class Case3 {

    /**
     * 瀑布流思想解题
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if(Objects.isNull(s)){
            return 0;
        }
        if(s.length() <= 1){
            return s.length();
        }
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Integer,Boolean> map = new HashMap<>(8);
            int temp = 1;
            map.put((int)s.charAt(i),true);
            for (int j = i+1; j < s.length(); j++) {
                if(Objects.nonNull(map.get((int)s.charAt(j)))){
                    break;
                }
                map.put((int)s.charAt(j),true);
                temp++;
            }
            maxLength = Math.max(temp, maxLength);
        }
        return maxLength;
    }

    /**
     * 滑动窗口解题
     * 固定窗口大小滑动子串，右指针碰到重复字段时，则将做指针移动至重复字段下一个，重复滑动
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(Objects.isNull(s)){
            return 0;
        }
        if(s.length() <= 1){
            return s.length();
        }
        int left = 0;
        int maxLength = 0;
        Map<Character,Integer> map = new HashMap<>(8);
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                //左指针滑动至重复key值的下一个键
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            //两种情况，
            // 不重复，则添加至map增加未重复的key
            // 重复，则对同样的key值进行更新只指针的value值
            map.put(s.charAt(i),i);
            maxLength = Math.max(maxLength,i-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Case3 case3 = new Case3();
        System.out.println(case3.lengthOfLongestSubstring1("abcabcdbb"));
        System.out.println(case3.lengthOfLongestSubstring("abcabcdbb"));
    }
}
