package com.baiyan.learn.math.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * NC137 表达式求值
 *
 * <href>
 *     https://www.nowcoder.com/practice/c215ba61c8b1443b996351df929dc4d4?tpId=117&&tqId=37849&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/19
 */
public class Casenc137 {

    public int solve (String s) {
        Stack<Character> op_stack = new Stack<Character>();
        Stack<Integer> num_stack = new Stack<Integer>();
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('(', 0);
            put('+', 1);
            put('-', 1);
            put('*', 2);
        }};

        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            //如果是(，就加入操作符栈
            if(s.charAt(i) == '('){
                op_stack.push(s.charAt(i));
            }
            //如果是)，就计算直到遇到(
            else if (s.charAt(i) == ')'){
                while(!op_stack.isEmpty()){
                    if(op_stack.peek() != '('){
                        cal(op_stack, num_stack);
                    } else{
                        op_stack.pop();
                        break;
                    }
                }
            }
            else{
                //如果是数字，就压入操作数栈
                if(Character.isDigit(s.charAt(i))){
                    int j = i;
                    while(j < s.length() && Character.isDigit(s.charAt(j))){
                        j++;
                    }
                    //多位需要截取字符串
                    num_stack.push(Integer.valueOf(s.substring(i, j)));
                    i = j - 1;
                }
                //如果是+-*操作符，则将其在(前的，运算优先级高的运算都做完
                //然后再压入当前操作符
                else{
                    while(!op_stack.isEmpty() && op_stack.peek() != '('){
                        if(map.get(s.charAt(i)) <= map.get(op_stack.peek())){
                            cal(op_stack, num_stack);
                        }
                        else{
                            break;
                        }

                    }
                    op_stack.push(s.charAt(i));
                }
            }
        }

        //将剩余计算计算完
        while(!op_stack.isEmpty()){
            cal(op_stack, num_stack);
        }
        return num_stack.peek();
    }

    public void cal (Stack<Character> op, Stack<Integer> num){
        if(op.isEmpty() || num.isEmpty() || num.size() < 2)
            return;
        int b = num.pop();
        int a = num.pop();
        char oper = op.pop();
        switch (oper){
            case '+':
                num.push(a + b);
                break;
            case '-':
                num.push(a - b);
                break;
            case '*':
                num.push(a * b);
                break;
        }
    }
}
