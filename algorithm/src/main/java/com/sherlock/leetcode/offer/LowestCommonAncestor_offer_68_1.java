package com.sherlock.leetcode.offer;

import com.sherlock.leetcode.common.TreeNode;

/**
 * @author Sherlock
 * @date 2022/2/14 17:09
 * @describe
 */
public class LowestCommonAncestor_offer_68_1 {

    /**
     * 二叉搜索树   搜索二叉树 是排好序的
     * @param root 二叉搜索树
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            //在左子树
            if (root.val> p.val && root.val> q.val){
                root = root.left;
            }
            else if (root.val< p.val && root.val< q.val){
                root = root.right;
            }else {
                break;
            }
        }
        return root;
    }
}
