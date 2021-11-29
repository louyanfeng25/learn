package com.baiyan.learn.math.offer;


import java.math.BigDecimal;
import java.util.Objects;

/**
 * NC100 把字符串转换成整数(atoi)
 *
 * <href>
 *     https://www.nowcoder.com/practice/d11471c3bf2d40f38b66bb12785df47f?tpId=117&&tqId=37754&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/29
 */
public class CaseNC100 {

    public int StrToInt (String s) {
        String check = s.replace(" ", "");
        if(check.isEmpty()){
            return 0;
        }
        if(!(check.startsWith("+") || check.startsWith("-") || (check.charAt(0)>='0') && (check.charAt(0)<='9'))){
            return 0;
        }
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if((s.charAt(i)=='-') || (s.charAt(i)=='+')){
                if(flag==0){
                  flag = 1;
                  sb.append(s.charAt(i));
                  continue;
                }else {
                    break;
                }
            }
            if((s.charAt(i)>='0') && (s.charAt(i)<='9')){
                if(flag==0){
                    flag = 1;
                }
                sb.append(s.charAt(i));
                continue;
            }
            if(flag==0){
                continue;
            }else {
                break;
            }
        }
        String s1 = sb.toString();
        if(Objects.equals(s1,"-") || Objects.equals(s1,"+")){
            return 0;
        }
        BigDecimal bigDecimal = new BigDecimal(Integer.MAX_VALUE);
        BigDecimal bigDecimal1 = new BigDecimal(s1);
        if(bigDecimal.compareTo(bigDecimal1.abs())!=-1){
            return Integer.valueOf(s1);
        }else {
            if(s1.startsWith("-")){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        CaseNC100 caseNC100 = new CaseNC100();
        System.out.println(caseNC100.StrToInt("+ 0 1234"));
    }

}
