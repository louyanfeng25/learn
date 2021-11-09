package com.baiyan.learn.math.offer.casenc12;

/**
 *  NC12	重建二叉树
 *
 * <href>
 *     https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=117&&tqId=37775&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/09
 */
public class CaseNC12 {


    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        return dfs(pre, 0, pre.length - 1, vin, 0, vin.length -1);
    }


    /**
     * 遍历处理
     * @param pre 先序遍历的数组
     * @param b1 先序遍历的起始位
     * @param e1 先序遍历的结束位
     * @param vin 中序遍历的数组
     * @param b2 中序遍历的起始位
     * @param e2 中序遍历的结束位
     * @return
     */
    public TreeNode dfs(int[] pre, int b1, int e1, int[] vin, int b2, int e2) {
        if (pre.length == 0 || vin.length == 0 || b1 > e1 || b2 > e2) {
            return null;
        }
        // 先序遍历，第一个节点必定为 根节点
        TreeNode root = new TreeNode(pre[b1]);
        // 已经只有一个节点了
        if (b1 == e1) {
            return root;
        }
        int i = b2;
        // 在中序遍历中找到根节点的位子
        for (;i < e2; i++) {
            if (vin[i] == root.val)  {
                break;
            }
        }
        //根节点左树长度
        int l = i - b2;
        //根节点右树长度
        int r = e2 - i;
        //左树遍历
        root.left = dfs(pre, b1 + 1, b1 + l, vin, b2, i);
        //右树遍历
        root.right = dfs(pre, b1 + 1 + l, e1, vin, i + 1, e2);
        return root;
    }


}
