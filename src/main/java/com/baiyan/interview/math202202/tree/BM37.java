package com.baiyan.interview.math202202.tree;

/**
 * BM37 二叉搜索树的最近公共祖先
 *
 * @author baiyan
 * @date 2022-03-01
 */
public class BM37 {

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if(q<root.val && p<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p>root.val && q>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root.val;
    }

}
