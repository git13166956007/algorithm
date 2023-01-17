package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/2/6 10:10
 *
 * @Version 1.0
 * @Note
 */
public class MirrorTree_offer_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        //只有一个节点
        if (root.left == null && root.right == null){
            return root;
        }
        //多个节点
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }


      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
