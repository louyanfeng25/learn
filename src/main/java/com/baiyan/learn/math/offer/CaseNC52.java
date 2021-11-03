package com.baiyan.learn.math.offer;

import java.util.Stack;


/**
 * NC52 括号序列
 *
 * <href>
 *     https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2?tpId=117&&tqId=37749&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/03
 */
public class CaseNC52 {

    /**
     * 压栈出栈方式
     *
     * @param s
     * @return
     */
    public boolean isValid (String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                stack.push(')');
            }
            else if (chars[i] == '['){
                stack.push(']');
            }
            else if (chars[i] == '{'){
                stack.push('}');
            }
            else if (stack.isEmpty() || chars[i] != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((int)'(');
        System.out.println((int)')');
        System.out.println((int)'[');
        System.out.println((int)']');
        System.out.println((int)'{');
        System.out.println((int)'}');
    }


}
