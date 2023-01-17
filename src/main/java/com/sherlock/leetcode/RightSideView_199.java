package com.sherlock.leetcode;

import java.util.*;

/**
 * @author Sherlock
 * @date 2022/1/18 10:21
 * @describe 199 二叉树的右视图
 */
public class RightSideView_199 {


    public List<Integer> rightSideView(TreeNode root) {
        //向右遍历 记录每一层的层号
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left !=null){
                    queue.offer(poll.left);
                }
                if (poll.right !=null){
                    queue.offer(poll.right);
                }
                //如果是队列中最后一个 则就是要的值
                if (i== size-1){
                    result.add(poll.val);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root1.left=root2;
        root1.right=root3;
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root2.left=null;
        root2.right=root5;
        root3.left = null;
        root3.right=root4;
        RightSideView_199 rightSideView_199 = new RightSideView_199();
        List<Integer> list = rightSideView_199.rightSideView(root1);
        list.forEach(System.out::println);

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
