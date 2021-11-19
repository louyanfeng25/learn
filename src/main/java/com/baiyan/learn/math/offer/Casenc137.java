package com.baiyan.learn.math.offer;

import java.util.HashMap;
import java.util.Stack;

/**
 * NC137 表达式求值
 *
 * <href>
 * https://www.nowcoder.com/practice/c215ba61c8b1443b996351df929dc4d4?tpId=117&&tqId=37849&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/19
 */
public class Casenc137 {

    public int solve(String s) {
        Stack<Integer> num_stack = new Stack<>();
        Stack<Character> op_stack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // '('直接入栈
            if (chars[i] == '(') {
                op_stack.push(chars[i]);
                // '）'遇到）则需要遍历操作数栈，如果操作数栈不为空，在遇到'（'前将结果计算下来缓存
                // 由于在最后一个else入栈操作符时，每次均会将前置的逻辑合并，因此只会至多留下两个数字跟一个操作符
            } else if (chars[i] == ')') {
                //需要）后，需要将（）中间的所有结果结算完结
                while (!op_stack.isEmpty()) {
                    if (op_stack.peek() != '(') {
                        cal(num_stack, op_stack);
                    } else {
                        op_stack.pop();
                        break;
                    }
                }
                //数字入栈需要截取出大于10的数字
            } else if (Character.isDigit(chars[i])) {
                int j = i;
                while (j < chars.length && Character.isDigit(chars[j])) {
                    j++;
                }
                Integer integer = Integer.valueOf(s.substring(i, j));
                num_stack.push(integer);
                i = j - 1;
                //循环计算（之前的数据，再将操作符入栈，这一步很重要，
                //操作符+-*入栈之前，需要将栈中（之前的符号数据按照优先级先进行合并计算
            } else {
                while (!op_stack.isEmpty() && op_stack.peek() != '(') {
                    if (map.get(chars[i]) <= map.get(op_stack.peek())) {
                        cal(num_stack, op_stack);
                    } else {
                        break;
                    }
                }
                op_stack.push(chars[i]);
            }
        }
        //还会剩下去除括号后的数据
        while (!op_stack.isEmpty()) {
            cal(num_stack, op_stack);
        }
        return num_stack.peek();
    }

    /**
     * 计算结果数据，将计算后的结果数据再次压栈等待后续关联计算
     *
     * @param num_stack
     * @param op_stack
     */
    public void cal(Stack<Integer> num_stack, Stack<Character> op_stack) {
        //防止直接出现+3，或者3这种情况
        if (num_stack.isEmpty() || op_stack.isEmpty() || num_stack.size() < 2) {
            return;
        }
        int num2 = num_stack.pop();
        int num1 = num_stack.pop();
        switch (op_stack.pop()) {
            case '+':
                num_stack.push(num1 + num2);
                break;
            case '-':
                num_stack.push(num1 - num2);
                break;
            case '*':
                num_stack.push(num1 * num2);
                break;
            default:
                break;
        }
    }


    public static void main(String[] args) {
        Casenc137 casenc137 = new Casenc137();
        //50
        int solve = casenc137.solve("3*(1+2*(3+4))+5");
        System.out.println(solve);
    }
}
