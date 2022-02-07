package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/1/27 16:30
 *
 * @Version 1.0
 * @Note
 */
public class IsSubStructure_offer_26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    private boolean recur(TreeNode A, TreeNode B) {
        if(B == null) {
            return true;
        }
        if(A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        a3.left = a4;
        a3.right = a5;
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        a4.left = a1;
        a4.right = a2;
        TreeNode aa4 = new TreeNode(4);
        TreeNode aa1 = new TreeNode(1);
        aa4.left = aa1;

        IsSubStructure_offer_26 isSubStructure_offer_26 = new IsSubStructure_offer_26();
        boolean subStructure2 = isSubStructure_offer_26.isSubStructure(a3, aa4);
        System.out.println(subStructure2);

    }
      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
