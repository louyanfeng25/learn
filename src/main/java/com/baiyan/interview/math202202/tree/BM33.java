package com.baiyan.interview.math202202.tree;

/**
 * BM33 二叉树的镜像
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM33 {

    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot==null){
            return null;
        }
        if(pRoot.right==null && pRoot.left==null){
            return pRoot;
        }
        TreeNode tmp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = tmp;

        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
