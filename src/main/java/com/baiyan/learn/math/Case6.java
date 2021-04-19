package com.baiyan.learn.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 *
 * <href>
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * </href>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 思路：此问题不要拘泥于Z字型排布，重要的是结果，最后以输出为主，Z字读取，行索引变大再变小，逐个拼接字符串即可。
 *
 * @author baiyan
 * @time 2021/4/14 16:03
 */
public class Case6 {

    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        //控制行索引变化
        int i = 0;
        //索引变化控制
        int flag = -1;
        for(char c:s.toCharArray()){
            rows.get(i).append(c);
            //触底或者到顶则进行转换索引变换方向
            if(i == 0 ||  i == numRows-1){
                flag = -flag;
            }
            i = i+flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Case6 case6 = new Case6();
        //标准输出： PAHNAPLSIIGYIR
        System.out.println(case6.convert("PAYPALISHIRING",3));
    }
}
