package com.baiyan.learn.math.offer.casenc14;

import java.util.ArrayList;
import java.util.Stack;


/**
 * NC14 按之字形顺序打印二叉树
 *
 * 思路：两个栈
 *
 * <href>
 *     https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=117&&tqId=37722&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/04
 */
public class CaseNc14 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot==null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(pRoot);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> child = new ArrayList<>();
            while (!stack1.isEmpty()){
                TreeNode pop = stack1.pop();
                if(pop.left!=null){
                    stack2.add(pop.left);
                }
                if(pop.right!=null){
                    stack2.add(pop.right);
                }
                child.add(pop.val);
            }
            if(child.size()!=0){
                list.add(child);
                continue;
            }
            while (!stack2.isEmpty()){
                TreeNode pop = stack2.pop();
                if(pop.right!=null){
                    stack1.add(pop.right);
                }
                if(pop.left!=null){
                    stack1.add(pop.left);
                }
                child.add(pop.val);
            }
            list.add(child);
        }
        return list;
    }

}
