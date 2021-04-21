package com.baiyan.learn.math;

/**
 * 91. 解码方法
 *
 * <href>
 *     https://leetcode-cn.com/problems/decode-ways/
 * </href>
 *
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *
 * 思路动态规划：
 * 状态转移方程
 * fi = f(i-1) , s[i]!=0;  最后切1位数
 * fi = f(i-2) , s[i-1]*10+s[i] <=26 && s[i-1]!=0 && i>1;   最后切两位数
 * 上述方程求和
 *
 * @author baiyan
 * @time 2021/4/21 09:32
 */
public class Case91 {

    public int numDecodings(String s) {
        // a = f[i-2],b=f[i-1],c=f[i]
        int a = 0;
        //此处设置基准时，默认b为起始的标志位，在长度为1的时候，并且数字不为0时，则返回b的数据
        int b = 1;
        int c = 0;
        //数组长度从1开始遍历，如果长度为0则直接返回C为0
        for (int i = 1; i <= s.length(); i++) {
            c = 0;
            //末尾切出1位的状态转移方程
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            //长度大于1的情况下，继续考虑能否切出2位数的状态转移方程
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            //一次循环结束后，f[i-2]与f[i-1]的值需要重新赋值
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Case91 case91 = new Case91();
        System.out.println(case91.numDecodings("12"));
        System.out.println(case91.numDecodings("226"));
        System.out.println(case91.numDecodings("0"));
        System.out.println(case91.numDecodings("06"));
    }
}
