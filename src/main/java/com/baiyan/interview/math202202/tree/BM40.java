package com.baiyan.interview.math202202.tree;

/**
 * BM40 重建二叉树
 *
 * @author baiyan
 * @date 2022-03-01
 */
public class BM40 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        return dfs(pre, 0, pre.length - 1, vin, 0, vin.length -1);
    }

    public TreeNode dfs(int[] pre, int b1, int e1, int[] vin, int b2, int e2) {
        if(pre.length==0 || vin.length==0 || b1>e1 || b2>e2){
            return null;
        }
        TreeNode root = new TreeNode(pre[b1]);
        if(b1==e1){
            return root;
        }
        //中序遍历中root节点的位置
        int rootIndex = b2;
        for (; rootIndex <=e2 ; rootIndex++) {
            if(vin[rootIndex] == pre[b1]){
                break;
            }
        }
        //左树长度
        int leftLength = rootIndex - b2;
        root.left = dfs(pre,b1+1,b1+leftLength,vin,b2,rootIndex);
        root.right = dfs(pre,b1+1+leftLength,e1,vin,rootIndex+1,e2);
        return root;
    }
}
