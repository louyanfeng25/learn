package com.baiyan.learn.math.offer.casenc16;

/**
 * NC16 对称的二叉树
 *
 * <href>
 *     https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=117&&tqId=37724&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/12/03
 */
public class CaseNc16 {

    public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null){
            return true;
        }

        return traverse(pRoot,pRoot);
    }

    public boolean traverse(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 != null && t2 != null) {
            return t1.val == t2.val && traverse(t1.left,t2.right) && traverse(t1.right, t2.left);
        }

        return false;
    }



    public static void main(String[] args) {
        CaseNc16 caseNc16 = new CaseNc16();
        TreeNode treeNode1  = new TreeNode(1);
        TreeNode treeNode2  = new TreeNode(2);
        TreeNode treeNode3  = new TreeNode(3);
        TreeNode treeNode4  = new TreeNode(3);
        TreeNode treeNode6  = new TreeNode(2);

        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode3.left = treeNode6;
        System.out.println(caseNc16.isSymmetrical(treeNode1));
    }

}
