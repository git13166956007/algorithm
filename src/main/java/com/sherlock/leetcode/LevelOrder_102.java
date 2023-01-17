package com.sherlock.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Sherlock
 * @date 2022/1/6 11:02
 * @describe 二叉树的层序遍历
 */
public class LevelOrder_102 {

    /**
     *  层序遍历不同于先序遍历 中序遍历 后序遍历 ,就是每一层从左到右进行遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root ==null ){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }


    public static void main(String[] args) {

        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        TreeNode node3 = new TreeNode(20,node4,node5);
        TreeNode node2 = new TreeNode(9);

        TreeNode node1 = new TreeNode(3,node2,node3);

        LevelOrder_102 levelOrder102 = new LevelOrder_102();
        List<List<Integer>> lists = levelOrder102.levelOrder(node1);
        System.out.println(lists.size());
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
