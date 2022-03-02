package com.baiyan.interview.math202202.queueStack;

import java.util.Objects;
import java.util.Stack;

/**
 * BM44 有效括号序列
 *
 * @author baiyan
 * @date 2022-03-02
 */
public class BM44 {

    public boolean isValid (String s) {
        if(s==null || s.length()==0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Objects.equals(c,'{')){
                stack.push('}');
                continue;
            }
            if(Objects.equals(c,'[')){
                stack.push(']');
                continue;
            }
            if(Objects.equals(c,'(')){
                stack.push(')');
                continue;
            }
            if(stack.isEmpty() || stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }

}
