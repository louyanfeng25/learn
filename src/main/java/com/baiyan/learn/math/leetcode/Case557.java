package com.baiyan.learn.math.leetcode;

/**
 * 557. 反转字符串中的单词 III
 *
 * <href>
 *     https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/24
 */
public class Case557 {

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            char[] chars = s1[i].toCharArray();
            int left = 0;
            int right = chars.length-1;
            while (left <  right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            for (char aChar : chars) {
             stringBuilder.append(aChar);
            }
            if(i!=s1.length-1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Case557 case557 = new Case557();
        String s = "Let's take LeetCode contest";
        System.out.println(case557.reverseWords(s));
    }
}
