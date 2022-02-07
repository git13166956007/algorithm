package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/2/6 10:34
 *
 * @Version 1.0
 * @Note
 */
public class IsSymmetric_offer_28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return recur(root.left,root.right);
    }

    private boolean recur(TreeNode left,TreeNode right){
        if (left == null&& right == null){
            return true;
        }
        if (left == null || right == null || right.val != left.val){
            return false;
        }
        return recur(left.right,right.left)&&recur(left.left,right.right);
    }


      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
