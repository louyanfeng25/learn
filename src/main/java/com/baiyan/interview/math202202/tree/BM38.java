package com.baiyan.interview.math202202.tree;

/**
 * BM38 在二叉树中找到两个节点的最近公共祖先
 *
 * @author baiyan
 * @date 2022-03-01
 */
public class BM38 {

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if(root==null){
            return -1;
        }
        //任意节点等于根节点则表示根节点为公共祖先
        if(root.val==p || root.val==q){
            return root.val;
        }
        int left = lowestCommonAncestor(root.left,p,q);
        int right = lowestCommonAncestor(root.right,p,q);
        //左树为不存在，则公共节点在右树
        if(left==-1){
            return right;
        }
        //右树不存在，则公共节点在作数
        if(right==-1){
            return left;
        }
        //左右都存在的话，则根节点为公共节点
        return root.val;
    }

}
