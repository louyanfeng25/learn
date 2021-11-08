package com.baiyan.learn.math.offer;


/**
 * NC103 反转字符串
 *
 * <href>
 *     https://www.nowcoder.com/practice/c3a6afee325e472386a1c4eb1ef987f3?tpId=117&&tqId=37827&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/08
 */
public class CaseNC103 {

    public String solve (String str) {
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CaseNC103 caseNC103 = new CaseNC103();
        System.out.println(caseNC103.solve("abcd"));

    }
}
