package com.baiyan.learn.math.offer.casenc6;

/**
 * NC6 二叉树中的最大路径和
 *
 * <href>
 *     https://www.nowcoder.com/practice/da785ea0f64b442488c125b441a4ba4a?tpId=117&&tqId=37716&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @date 2021/12/02
 */
public class CaseNC6 {
    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum (TreeNode root) {
        traverseTree(root);
        return maxValue;
    }

    public void traverseTree(TreeNode root){
        if(root==null){
            return;
        }
        signal(root);
        traverseTree(root.left);
        traverseTree(root.right);
    }

    public void signal(TreeNode root){
        if(root==null){
            return;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        int max = Math.max(root.val + left, root.val + right);
        max = Math.max(max, root.val + right+left);
        max = Math.max(max, root.val);
        maxValue = Math.max(max, maxValue);
    }

    public int traverse(TreeNode root){
        if(root==null){
            return 0;
        }
        int maxLeft = traverse(root.left);
        int maxRight = traverse(root.right);
        return Math.max(Math.max(root.val+maxLeft,root.val+maxRight),root.val);
    }

    public static void main(String[] args) {
        CaseNC6 caseNC6 = new CaseNC6();
        TreeNode treeNode1 = new TreeNode(-20);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(caseNC6.maxPathSum(treeNode1));
    }
}
