package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/1/25 14:49
 *
 * @Version 1.0
 * @Note
 */
public class TwoSum_offer_57 {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right  = len-1;
        while (left<=right){
            if (nums[left]+nums[right] == target){
                return new int[]{nums[left],nums[right]};
            }else if (nums[left]+nums[right] > target){
                right -- ;
            }else {
                left ++ ;
            }
        }
        return nums;
    }
}
