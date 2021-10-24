package com.baiyan.learn.math.leetcode;

/**
 * 344. 反转字符串
 *
 * <href>
 *     https://leetcode-cn.com/problems/reverse-string/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/24
 */
public class Case344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left <  right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        Case344 case344 = new Case344();
        char[] chars = new char[]{'h','e','l','l','o'};
        case344.reverseString(chars);
        System.out.println(chars);
    }
}
