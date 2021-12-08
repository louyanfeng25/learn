package com.baiyan.learn.math.offer;

import java.util.ArrayList;

/**
 * NC20 数字字符串转化成IP地址
 *
 * <href>
 * https://www.nowcoder.com/practice/ce73540d47374dbe85b3125f57727e1e?tpId=117&&tqId=37725&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/12/08
 */
public class CaseNc20 {

    ArrayList<String> res = new ArrayList<>();

    /**
     * 思路
     * 通过插入小数据点的方式进行递归，当待插入的小数点个数为0时
     * 按照.进行切割字符串，校验每个ip段不大于255，且每个段大于9时，开始字符不可以为0
     * 特别需要注意：有可能截取后最有一个段为空，所以需要校验切割后的字符串是不是个数为4，例如885->8.8.5.
     *
     *
     * @param s
     * @return
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        if (s.length() == 0) {
            return res;
        }
        //在字符串S中插入3个点，从字符下标0开始下移插入
        backTrack(s, 0, 3);
        return res;
    }

    /**
     * 插入小数点生成ip
     *
     * @param s     待插入的小数点的字符串
     * @param start 起始坐标
     * @param cnt   剩余的小数点数目
     */
    public void backTrack(String s, int start, int cnt) {
        if (cnt == 0) {
            String[] strings = s.split("\\.");
            //小数点插完了，但是最后一位空了，例如885->8.8.5.
            if (strings.length < 4) {
                return;
            }
            for (String string : strings) {
                //ip段大于9时，每个字符串都不能以0开头，且ip段数字不能大于255
                if (string.length() > 1 && string.charAt(0) == '0' || Integer.valueOf(string) > 255) {
                    return;
                }
            }
            res.add(s);
            return;
        }
        int length = s.length();
        //已经没有字符可以进行拼接了
        if (start >= length) {
            return;
        }
        //每次截取1位，start在经过一次截取后，传递到下一次递归时需要+2，因为要把.包进去，从.后面以为开始重新截取，然后小数点个数-1
        backTrack(s.substring(0, start + 1) + "." + s.substring(start + 1, length), start + 2, cnt - 1);
        //每次截取2位
        if (start < length - 2) {
            backTrack(s.substring(0, start + 2) + "." + s.substring(start + 2, length), start + 3, cnt - 1);
        }
        //每次截取3位
        if (start < length - 3) {
            backTrack(s.substring(0, start + 3) + "." + s.substring(start + 3, length), start + 4, cnt - 1);
        }
    }

    public static void main(String[] args) {
        CaseNc20 caseNc20 = new CaseNc20();
        ArrayList<String> strings = caseNc20.restoreIpAddresses("1111");
        strings.forEach(System.out::println);
    }
}
