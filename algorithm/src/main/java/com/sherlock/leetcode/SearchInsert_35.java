package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/20 14:43
 * @describe
 */
public class SearchInsert_35 {

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length-1;
        while (low <= high){
            int middle = (high-low)/2 + low;
            if (nums[middle] == target){
                return middle;
            }
            if(nums[middle]< target){
                low = middle + 1;
            }else {
                high = middle - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 0;
        SearchInsert_35 searchInsert_35 = new SearchInsert_35();
        int i = searchInsert_35.searchInsert(nums, target);
        System.out.println(i);
    }
}
