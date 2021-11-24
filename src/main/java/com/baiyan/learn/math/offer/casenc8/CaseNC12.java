package com.baiyan.learn.math.offer.casenc8;

import java.util.ArrayList;

/**
 *  NC8 二叉树中和为某一值的路径(二)
 *
 * <href>
 *     https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=117&&tqId=37718&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/24
 */
public class CaseNC12 {

    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        if(root==null){
            return lists;
        }
        traverse(root,0,new ArrayList<>(),expectNumber);
        return lists;
    }

    public void traverse(TreeNode root, int sum,ArrayList<Integer> list,int expectNumber){
        if(root.left==null && root.right==null){
            sum = sum + root.val;
            if(sum == expectNumber){
                list.add(root.val);
                lists.add(list);
            }
            return;
        }
        sum = sum + root.val;
        list.add(root.val);
        if(root.left!=null){
            ArrayList<Integer> objects = new ArrayList<>();
            objects.addAll(list);
            traverse(root.left,sum,objects,expectNumber);
        }
        if(root.right!=null){
            ArrayList<Integer> objects = new ArrayList<>();
            objects.addAll(list);
            traverse(root.right,sum,objects,expectNumber);
        }
    }

    public static void main(String[] args) {
        CaseNC12 caseNC5 = new CaseNC12();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        ArrayList<ArrayList<Integer>> lists = caseNC5.FindPath(treeNode1, 3);
        System.out.println(lists.toString());
    }

}
