package com.baiyan.learn.math;

/**
 * 最长回文子串（5）
 *
 * <href>
 *     https://leetcode-cn.com/problems/longest-palindromic-substring/
 * </href>
 *
 * 思路：
 * p(i,j)=p(i+1,j-1)&&pi==pj
 * 中心扩展，单节点必为回文串，以单节点为中心往外进行扩散，两边节点值相等即为回文串。记录比较即可
 *
 * @author baiyan
 * @time 2021/4/14 13:44
 */
public class Case5 {

    public String longestPalindrome(String s) {
        int length = s.length();
        String maxString = "";
        boolean[][] p = new boolean[length][length];
        int end = 0;
        int maxlength = 0;
        //获取各种长度的串
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                end = start + len -1;
                //防止end数组下标越界
                if(end >=length){
                    break;
                }
                //长度为1与2需要单独处理，长度为2时，存在下标反补现象，比如p[0][1]--> p[1][0]长度串不符合规定（start>end）
                p[start][end] = (len==1 || len==2 || p[start+1][end-1]) && s.charAt(start) == s.charAt(end);
                //根据start与end组合并且比较长度来决定是否为回文串，并且记录给最长子串
                if(p[start][end] && len>maxlength){
                    maxString = s.substring(start,end+1);
                }
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        Case5 case5 = new Case5();
        System.out.println(case5.longestPalindrome("cbbd"));
    }
}
