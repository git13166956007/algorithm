package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/1/23 17:55
 *
 * @Version 1.0
 * @Note
 */
public class MissingNumber_offer_53 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        while (low<=high){
            int mid = low + (high - low)/2;
            if (nums[mid] > mid){
                high = mid -1 ;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int [] nums = new int[]{0,1,2,4,5,6,7,8,9};
        MissingNumber_offer_53 missingNumber_offer_53 = new MissingNumber_offer_53();
        int i = missingNumber_offer_53.missingNumber(nums);
        System.out.println(i);
    }
}
