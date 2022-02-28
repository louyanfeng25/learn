package com.baiyan.interview.math202202.tree;

/**
 * BM30 二叉搜索树与双向链表
 *
 * 解题关键为中序遍历，记录前置节点
 *
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM30 {

    /**
     * 链表的头结点
     */
    TreeNode root = null;

    /**
     * 临时记录的前置节点
     */
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }

        Convert(pRootOfTree.left);

        if(root==null){
            root = pRootOfTree;
        }
        if(pre!=null){
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;

        Convert(pRootOfTree.right);

        return root;
    }

}
