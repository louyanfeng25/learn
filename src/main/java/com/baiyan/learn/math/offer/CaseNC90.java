package com.baiyan.learn.math.offer;

import java.util.Stack;

/**
 * NC90 包含min函数的栈
 *
 * <href>
 *      https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=117&&tqId=37793&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/10
 */
public class CaseNC90 {

    Stack<Integer> normal= new Stack<Integer>();
    Stack<Integer> minval= new Stack<Integer>();

    public void push(int node) {
        normal.push(node);
        if(minval.isEmpty() || minval.peek()>node){
            minval.push(node);
        }else {
            minval.push(minval.peek());
        }
    }

    public void pop() {
        normal.pop();
        minval.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return minval.peek();
    }
}
