package com.sherlock.leetcode;

import java.util.Arrays;

/**
 * @author Sherlock
 * @date 2022/8/9 0009 22:14
 * @describe
 **/
public class SpecialArray_1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        int target = nums.length;
        while (left<= right){
            int mid = left + (right - left)/2;
            if (target<nums[mid]){

            }
        }

        return 1;
    }
}
