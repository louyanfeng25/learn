package com.baiyan.interview.math202202.tree;

/**
 * BM31 对称的二叉树
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM31 {

    public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null){
            return true;
        }

        return traverse(pRoot,pRoot);
    }

    private boolean traverse(TreeNode t1,TreeNode t2){
        if(t1==null && t2==null){
            return true;
        }
        if(t1!=null && t2!=null){
            return  t1.val == t2.val && traverse(t1.left,t2.right) && traverse(t2.left,t1.right);
        }
        return false;
    }

}
