package com.baiyan.learn.math.offer.casenc5;

/**
 * NC5 二叉树根节点到叶子节点的所有路径和
 *
 * <href>
 *     https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=117&&tqId=37715&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/24
 */
public class CaseNC5 {
    int totalSum = 0;

    public int sumNumbers (TreeNode root) {
        if(root==null){
            return 0;
        }
        traverse(root,new String());
        return totalSum;
    }

    public void traverse(TreeNode root,String string){
        if(root.left==null && root.right==null){
            string = string+root.val;
            totalSum = Integer.valueOf(string) + totalSum;
            return;
        }
        string = string+root.val;
        if(root.left!=null){
            traverse(root.left,string);
        }
        if(root.right!=null){
            traverse(root.right,string);
        }
    }

    public static void main(String[] args) {
        CaseNC5 caseNC5 = new CaseNC5();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(caseNC5.sumNumbers(treeNode1));
    }

}
