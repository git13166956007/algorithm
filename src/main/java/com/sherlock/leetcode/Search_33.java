package com.sherlock.leetcode;

/**
 * @author sherlock
 * @describe 33 搜索旋转排序数组
 */
public class Search_33 {
    /**
     *  整数数组nums[] 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
     *  使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
     *  例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *  给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     *
     *  eg:
     * @param nums 目标数组
     * @param target 目标值
     * @return
     */
    public int search(int[] nums, int target) {
        //找到变换点的数据 ，然后还原
        //时间复杂度为O(n)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]== target){
                return i;
            }
        }

        int tail = nums.length-1;
        for (int i = 0; i < nums.length; i++,tail--) {
            if (nums[i]== target){
                return i;
            }
            if (nums[tail]== target){
                return tail;
            }

        }

        //二分法进行搜索
        //找出中点
        int mid = (nums.length-1)/2;
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,6,7,8,1,2,3,4};
        System.out.println((nums.length-1)/2);
    }


}
