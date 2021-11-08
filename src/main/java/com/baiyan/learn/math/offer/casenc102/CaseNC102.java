package com.baiyan.learn.math.offer.casenc102;


/**
 * NC102 在二叉树中找到两个节点的最近公共祖先
 *
 * 递归思路： 自顶向下遍历，遍历到值等于o1或者o2,则返回节点值，然后判断返回的左右节点是否都不等于-1，
 * 如果不等于-1则返回当前节点值递推上去。
 *
 * <href>
 *     https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116?tpId=117&&tqId=37826&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/08
 */
public class CaseNC102 {

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // 如果树为空，直接返回null
        if(root==null) {
            return -1;
        }
        // 如果 o1和o2中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        if(o1==root.val || o2==root.val) {
            return root.val;
        }
        // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        int left = lowestCommonAncestor(root.left, o1, o2);
        // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        int right = lowestCommonAncestor(root.right,o1,o2);
        // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        if(left ==-1) {
            return right;
        }
        // 否则，如果 left不为空，在左子树中有找到节点（p或q），这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        if(right ==-1)  {
            return left;
        }
        //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
        return root.val;
    }


}
