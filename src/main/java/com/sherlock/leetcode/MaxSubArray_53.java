package com.sherlock.leetcode;

import java.util.Arrays;

/**
 * @author Sherlock
 * @date 2022/1/17 11:30
 * @describe
 */
public class MaxSubArray_53 {

    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int max = 0;
        int result = Integer.MIN_VALUE ;
        for (int num : nums) {
            //如果当前值比 前子序列的和的值还要大。则丢弃前子序列的和，更新为当前值的大小
            max = Math.max(num, max + num);
            result = Math.max(result, max);
        }
        return result;
    }


    public int maxSubArray_2(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i-1]<=0){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i-1]+nums[i];
            }
        }
        Arrays.sort(dp);
        return dp[length-1];
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{-2,-1};
//        int[] nums = new int[]{5,4,-1,7,8};
//        int[] nums = new int[]{1,2};
//        MaxSubArray_53 maxSubArray_53 = new MaxSubArray_53();
//        int i = maxSubArray_53.maxSubArray_2(nums);
//        System.out.println(i);
        System.out.println(8%5);
    }
}
