package com.sherlock.leetcode;

import com.sherlock.leetcode.common.TreeNode;

/**
 * @author sherlock
 * @date 2022/9/2 9:51
 * @node
 **/
public class LongestUnivaluePath_687 {

    int maxValue = 0;
    /**
     * 5,4,5,1,1,5
     *
     *1,4,5,4,4,5
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {

        if (root==null){
            return 0;
        }
        dfs(root, root.val);
        return maxValue;
    }


    public int dfs(TreeNode root ,int preVale){
        if (root==null){
            return 0;
        }
        int left = dfs(root.left,root.val);
        int right = dfs(root.right,root.val);
        maxValue=Math.max(maxValue,left+right);
        if (root.val == preVale ){
            return Math.max(left,right)+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(2,treeNode3,treeNode4);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2,treeNode6,treeNode5);
        TreeNode treeNode0 = new TreeNode(1,treeNode1,treeNode2);

        //[1,2,2,2,2,2,2,2]

        LongestUnivaluePath_687 longestUnivaluePath_687 = new LongestUnivaluePath_687();
        int i = longestUnivaluePath_687.longestUnivaluePath(treeNode0);
        System.out.println(i);
    }
}
