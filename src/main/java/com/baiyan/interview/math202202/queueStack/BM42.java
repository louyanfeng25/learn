package com.baiyan.interview.math202202.queueStack;

import java.util.Stack;

/**
 * BM42 用两个栈实现队列
 *
 * @author baiyan
 * @date 2022-03-02
 */
public class BM42 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        return -1;
    }

}
