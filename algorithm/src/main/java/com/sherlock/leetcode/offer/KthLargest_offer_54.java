package com.sherlock.leetcode.offer;

import java.util.PriorityQueue;

/**
 * @author Sherlock
 * @date 2022/2/11 17:39
 * @describe
 */
public class KthLargest_offer_54 {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
    int index = 0;
    int[] result = new int[1];
    public int kthLargest(TreeNode root, int k) {
//        dfs(root);
//        int index = 1;
//        while (!priorityQueue.isEmpty()){
//            if (index==k){
//                return priorityQueue.poll();
//            }
//            priorityQueue.poll();
//            index ++;
//        }
        dfs2(root,k);
        return result[0];
    }
    private void dfs(TreeNode root){
        if (root ==null ){
            return;
        }
        priorityQueue.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }


    private void dfs2(TreeNode root, int k){
        //先寻找右节点
        if (root.right!=null){
            dfs2(root.right,k);
        }
        if (++index ==k){
            result[0]=root.val;
        }
        if (root.left!=null){
            dfs2(root.left,k);
        }
    }


    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(1);
//        TreeNode treeNode3 = new TreeNode(4);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        TreeNode treeNode4 = new TreeNode(2);
//        treeNode2.right = treeNode4;

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.right = treeNode2;
        KthLargest_offer_54 kthLargest_offer_54 = new KthLargest_offer_54();
        int i = kthLargest_offer_54.kthLargest(treeNode1, 2);
        System.out.println(i);
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
