package com.baiyan.learn.math.offer.casenc62;

/**
 *  NC62 判断是不是平衡二叉树
 *
 * <href>
 *     https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=117&&tqId=37757&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/18
 */
public class CaseNC62 {

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;
    }

    /**
     * 只要底层有一个子树不是平衡二叉树就直接一路返回了
     * @param root
     * @return
     */
    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        if (left==-1){
            return -1;
        }
        int right = getDepth(root.right);
        if (right ==-1){
            return -1;
        }
        return Math.abs(left-right)>1 ? -1 : 1+Math.max(left,right);
    }


}
