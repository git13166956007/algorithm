package com.sherlock.leetcode.offer;

import com.sherlock.leetcode.common.TreeNode;

/**
 * @author Sherlock
 * @date 2022/2/14 16:04
 * @describe
 */
public class IsBalanced_offer_55_2 {

    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        int dfs = dfs(root);
        return dfs != -1;
    }


    private int dfs(TreeNode root){
        if (root ==null){
            return 0;
        }
        int dfs_left = dfs(root.left);
        if (dfs_left == -1){
            return -1;
        }
        int dfs_right = dfs(root.right);
        if (dfs_right == -1){
            return -1;
        }
        return Math.abs(dfs_left - dfs_right)<2?Math.max(dfs_left,dfs_right)+1:-1;
    }

}
