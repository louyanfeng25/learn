package com.baiyan.learn.math.offer;

/**
 * NC19 连续子数组的最大和
 *
 * <href>
 *     https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=117&&tqId=37842&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/03
 */
public class CaseNc1 {

    public String solve (String s, String t) {

        if(s.length()>t.length()){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length()-t.length(); i++) {
                sb.append("0");
            }
            t = sb.toString()+t;
        }
        if(s.length()<t.length()){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < t.length()-s.length(); i++) {
                sb.append("0");
            }
            s = sb.toString()+s;
        }
        int flag = 0;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = s.length()-1; i >=0; i--) {
             int sum = chars1[i] + chars2[i] + flag - 48*2;
             if(sum>=10){
                 flag = 1;
                 sum = sum - 10;
             }else {
                 flag = 0;
             }
             chars1[i] = (char)(sum+48);
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(flag==1){
            stringBuilder.append(1);
        }
        for (char c:chars1){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CaseNc1 caseNc1 = new CaseNc1();
        System.out.println(caseNc1.solve("12345","99123"));
    }
}
