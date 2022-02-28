package com.baiyan.interview.math202202.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * BM27 按之字形顺序打印二叉树
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM27 {

    /**
     * 双栈思路
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot==null){
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> result = new ArrayList<>();
            while (!stack1.isEmpty()){
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = stack1.pop();
                    result.add(pop.val);
                    if(pop.left!=null){
                        stack2.add(pop.left);
                    }
                    if(pop.right!=null){
                        stack2.add(pop.right);
                    }
                }
            }
            if(!result.isEmpty()){
                results.add(result);
                continue;
            }
            while (!stack2.isEmpty()){
                int size = stack2.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = stack2.pop();
                    result.add(pop.val);
                    if(pop.right!=null){
                        stack1.add(pop.right);
                    }
                    if(pop.left!=null){
                        stack1.add(pop.left);
                    }
                }
            }
            results.add(result);
        }
        return results;
    }
}
