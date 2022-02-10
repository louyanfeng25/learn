package com.baiyan.learn.math.offer;

import java.util.Stack;

/**
 * NC76 用两个栈实现队列
 *
 * <href>
 *     https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=117&tqId=37774&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117%26page%3D1&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * </href>
 *
 * @author baiyan
 * @time 2022/02/10
 */
public class CaseNc76 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("队列为空");
        }
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
