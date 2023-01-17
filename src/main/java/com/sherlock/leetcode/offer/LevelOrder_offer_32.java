package com.sherlock.leetcode.offer;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Sherlock on 2022/1/27 14:53
 *
 * @Version 1.0
 * @Note
 */
public class LevelOrder_offer_32 {

    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            for (int i = 0;i < queue.size();i++){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
