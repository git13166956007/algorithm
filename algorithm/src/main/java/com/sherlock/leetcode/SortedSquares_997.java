package com.sherlock.leetcode;

/**
 * Created by Sherlock on 2022/1/23 21:20
 *
 * @Version 1.0
 * @Note
 */
public class SortedSquares_997 {

    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int [] result = new int[len];
        int r = result.length -1;
        while (low <= high){
            if (nums[low]*nums[low]> nums[high]*nums[high]){
                result[r--] = nums[low]*nums[low];
                low++;
            }else {
                result[r--] = nums[high]*nums[high];
                high--;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{-4,-1,0,3,10};
        SortedSquares_997 sortedSquares_997 = new SortedSquares_997();
        int[] ints = sortedSquares_997.sortedSquares(nums);

        System.out.println(ints);
    }
}
