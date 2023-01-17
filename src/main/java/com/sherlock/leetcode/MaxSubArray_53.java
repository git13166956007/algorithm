package com.sherlock.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Sherlock
 * @date 2022/1/17 11:30
 * @describe
 */
public class MaxSubArray_53 {

    public int maxSubArray(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int maxAnswer = nums[0];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果当前值比 前子序列的和的值还要大。则丢弃前子序列的和，更新为当前值的大小
            result = Math.max(result+nums[i],nums[i]);
            maxAnswer = Math.max(maxAnswer,result);
        }
        return maxAnswer;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{5,4,-1,7,8};
        MaxSubArray_53 maxSubArray_53 = new MaxSubArray_53();
        int i = maxSubArray_53.maxSubArray(nums);
        System.out.println(i);
    }
}
