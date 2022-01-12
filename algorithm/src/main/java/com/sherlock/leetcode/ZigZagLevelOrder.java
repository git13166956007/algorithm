package com.sherlock.leetcode;

import java.util.*;

/**
 * @author Sherlock
 * @date 2022/1/6 9:42
 * @describe 二叉树的锯齿形层序遍历
 */
public class ZigZagLevelOrder {

    /**
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如:给定二叉树 [3,9,20,null,null,15,7]
     *       3
     *      /  \
     *     9    20
     *         /  \
     *        15   7
     *
     *  返回锯齿形层序遍历如下:
     *  [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     * @param root 根节点树
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return null;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int flag = 0;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode poll = nodeQueue.poll();
                if (flag%2==0) {
                    levelList.offerLast(poll.val);
                } else {
                    levelList.offerFirst(poll.val);
                }
                if (poll.left != null) {
                    nodeQueue.offer(poll.left);
                }
                if (poll.right != null) {
                    nodeQueue.offer(poll.right);
                }
            }
            result.add(new ArrayList<>(levelList));
            flag++;
        }
        return result;
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

    public static void main(String[] args) {

        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        TreeNode node3 = new TreeNode(20,node4,node5);
        TreeNode node2 = new TreeNode(9);

        TreeNode node1 = new TreeNode(3,node2,node3);

        ZigZagLevelOrder zigZagLevelOrder  = new ZigZagLevelOrder();
        List<List<Integer>> lists = zigZagLevelOrder.zigzagLevelOrder(node1);
        System.out.println(lists.size());
    }
}
