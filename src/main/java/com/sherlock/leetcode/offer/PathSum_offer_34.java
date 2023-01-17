package com.sherlock.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sherlock
 * @date 2022/2/11 16:05
 * @describe
 */
public class PathSum_offer_34 {

    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> paths = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        //左侧
        dfs(root,target);
        return result;
    }

    private void dfs(TreeNode root, int target){
        if (root ==null){
            return;
        }
        paths.add(root.val);
        target -= root.val;
        if (root.left ==null && root.right==null && target == 0){
            result.add(new ArrayList<>(paths));
        }
        dfs(root.left,target);
        dfs(root.right,target);
        paths.removeLast();
    }


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int x){
            val = x;
        }
        TreeNode(int x,TreeNode left,TreeNode right){
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}
