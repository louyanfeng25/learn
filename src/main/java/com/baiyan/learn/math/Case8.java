package com.baiyan.learn.math;

/**
 * 字符串转换整数 (atoi)(8)
 *
 * <href>
 *     https://leetcode-cn.com/problems/string-to-integer-atoi/
 * </href>
 *
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 思路：直接暴力破解，纯数字计算，不使用复杂的算法方式
 *
 * @author baiyan
 * @time 2021/4/15 09:16
 */
public class Case8 {

    public int myAtoi(String s) {
        int result = 0;
        int count = 0;
        int sign = 1;
        for(char c : s.toCharArray()){
            //计数开始后碰到非数字直接退出
            if(count>0 && (c<48 || c > 57)){
                break;
            }
            //忽略前导空格
            if(c == 32 && count ==0){
                continue;
            }
            //非数字，+，-，开头的直接跳出循环
            if(count == 0 && (c<48 || c > 57) && c!= 45 && c!=43){
                break;
            }
            //+符号处理
            if(c==43){
                count++;
                continue;
            }
            //-符号处理
            if(c==45){
                sign = -sign;
                count++;
                continue;
            }
            //数字计算
            if(c>47 && c< 58){
                //判断数字边界
                if(( Integer.MAX_VALUE/10 < result )||( Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE%10< Integer.parseInt(String.valueOf(c)))){
                    return sign==1?Integer.MAX_VALUE*sign:Integer.MIN_VALUE*sign;
                }
                result = result*10 + Integer.parseInt(String.valueOf(c));
                count++;
            }
        }

        return result*sign;
    }

    public static void main(String[] args) {
        Case8 case8 = new Case8();
//        //32
//        System.out.println((int)' ');
//        //45
//        System.out.println((int)'-');
//        //48
//        System.out.println((int)'0');
//        //57
//        System.out.println((int)'9');
        System.out.println(case8.myAtoi("+1"));
    }
}
