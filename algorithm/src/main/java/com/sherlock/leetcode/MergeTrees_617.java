package com.sherlock.leetcode;

/**
 * Created by Sherlock on 2022/1/27 11:18
 *
 * @Version 1.0
 * @Note
 */
public class MergeTrees_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 先合并根节点
        TreeNode root = new TreeNode(root1.val + root2.val);
        // 再递归合并左右子树
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode2;
        TreeNode treeNode5 = new TreeNode(5);
        treeNode3.left = treeNode5;


        TreeNode treeNode22 = new TreeNode();
        TreeNode treeNode11 = new TreeNode();
        TreeNode treeNode33 = new TreeNode();
        treeNode22.left = treeNode11;
        treeNode22.right = treeNode33;
        TreeNode treeNode44 = new TreeNode();
        treeNode11.right = treeNode44;
        TreeNode treeNode77 = new TreeNode();
        treeNode33.right = treeNode77;

        MergeTrees_617 mergeTrees_617 = new MergeTrees_617();
        TreeNode treeNode = mergeTrees_617.mergeTrees(treeNode1, treeNode22);
        System.out.println(treeNode.val);
    }


    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
   }
}
