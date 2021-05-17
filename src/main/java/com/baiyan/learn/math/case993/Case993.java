package com.baiyan.learn.math.case993;

import java.util.Objects;

/**
 * 二叉树的堂兄弟节点
 *
 * <href>
 *     https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * </href>
 *
 * @author baiyan
 * @time 2021/5/17 09:27
 */
public class Case993 {

    int deep=0;

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode left = traverseDeep(root,0, x);
        int xDeep = deep;
        this.deep = 0;
        TreeNode right = traverseDeep(root,0, y);
        int yDeep = deep;
        if(Objects.isNull(left)||Objects.isNull(right)){
            return false;
        }
        return !Objects.equals(left.val,right.val) && Objects.equals(xDeep,yDeep);
    }

    public TreeNode traverseDeep(TreeNode root,int deep,int expect){
        if(Objects.isNull(root)){
            return null;
        }
        ++deep;
        if(Objects.nonNull(root.left) && Objects.equals(root.left.val,expect)){
            this.deep = deep;
            return root;
        }
        if(Objects.nonNull(root.right) && Objects.equals(root.right.val,expect)){
            this.deep = deep;
            return root;
        }
        TreeNode left = traverseDeep(root.left, deep,expect);
        TreeNode right = traverseDeep(root.right, deep,expect);
        return Objects.isNull(left) ? right : left;
    }

    public static void main(String[] args) {
        Case993 case993 = new Case993();
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, null);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1,treeNode2,treeNode3);
        System.out.println(case993.isCousins(treeNode1,3,4));



        TreeNode treeNode41 = new TreeNode(4);
        TreeNode treeNode51 = new TreeNode(5);
        TreeNode treeNode21 = new TreeNode(2, null, treeNode41);
        TreeNode treeNode31 = new TreeNode(3,null,treeNode51);
        TreeNode treeNode11 = new TreeNode(1,treeNode21,treeNode31);
        System.out.println(case993.isCousins(treeNode11,5,4));
    }
}
