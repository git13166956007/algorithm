package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/12 13:44
 * @describe 236 二叉树的最近公共祖先
 */
public class LowestCommonAncestor_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || p == root || q == root){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode!=null){
            return leftNode;
        }
        if (rightNode!=null){
            return rightNode;
        }
        return null;
    }

    static class TreeNode{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
