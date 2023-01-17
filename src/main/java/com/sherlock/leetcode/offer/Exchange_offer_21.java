package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/1/25 15:01
 *
 * @Version 1.0
 * @Note
 */
public class Exchange_offer_21 {
    /**
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len -1;
        while (left<right){
            if (nums[left]%2 != 0){
                //奇数
                left ++;
            }else if (nums[right]%2 == 0){
                right --;
            }
            if (left<right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        Exchange_offer_21 exchange_offer_21 = new Exchange_offer_21();
        exchange_offer_21.exchange(nums);
    }
}
