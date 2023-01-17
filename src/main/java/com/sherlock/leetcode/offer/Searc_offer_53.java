package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/1/23 17:22
 *
 * @Version 1.0
 * @Note
 */
public class Searc_offer_53 {

    public int search(int[] nums, int target) {

        int len = nums.length;
        int low = 0;
        int high = len -1;
        int result = 0;
        while (low<= high){
            int mid = (high-low)/2 + low;
            if (nums[mid]< target){
                low = mid +1;
            }else {
                high = mid-1;
            }
        }
        while(low<len && nums[low++] == target){
            result++;
        }
        return result;

    }
}
