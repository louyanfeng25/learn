package com.baiyan.interview.math202202.tree;

/**
 * BM32 合并二叉树
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM32 {

    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null){
            return null;
        }
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }

}
