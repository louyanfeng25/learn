package com.baiyan.learn.math.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 567. 字符串的排列
 *
 * <href>
 *     https://leetcode-cn.com/problems/permutation-in-string/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/26
 */
public class Case567 {

    /**
     * 暴力单边遍历破解
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }
        if(Objects.equals(s1,s2)){
            return true;
        }
        char[] chars = s1.toCharArray();
        Map<Character,Integer> change = new HashMap<>();
        for (char aChar : chars) {
            Integer orDefault = change.getOrDefault(aChar, 0);
            change.put(aChar,orDefault+1);
        }
        int left = 0;
        int right = 0;
        char[] s2Chars = s2.toCharArray();
        boolean exist = false;
        while (right<s2.length()){
            if(Objects.nonNull(change.get(s2Chars[right])) && change.get(s2Chars[right])>0){
                change.put(s2Chars[right],change.get(s2Chars[right])-1);
                right++;
            }else{
                right = ++left;
                exist = true;
                for (Character character : change.keySet()) {
                    if(!Objects.equals(change.get(character),0)){
                        exist = false;
                        break;
                    }
                }
                if(exist){
                    break;
                }
                change = new HashMap<>();
                for (char aChar : chars) {
                    Integer orDefault = change.getOrDefault(aChar, 0);
                    change.put(aChar,orDefault+1);
                }
            }
        }
        for (Character character : change.keySet()) {
            if(Objects.equals(change.get(character),0)){
                exist = true;
            }else {
                exist = false;
                break;
            }
        }
        return exist;
    }

    /**
     * 滑动窗口比较两个串里面的字符个数是否相等
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        //26个字母长度的数组
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        //窗口滑动，右边加一个，左边减少一个
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Case567 case567 = new Case567();
        System.out.println(case567.checkInclusion("adc","dcda"));
    }
}
