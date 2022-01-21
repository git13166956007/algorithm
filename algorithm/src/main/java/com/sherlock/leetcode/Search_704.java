package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/20 10:44
 * @describe
 */
public class Search_704 {

    /**
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 二分法查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int middle =  low + high>>1 ;
            if (target==nums[middle]){
                return middle;
            }
            if (target > nums[middle]){
                low = middle+1;
            }else {
                high = middle-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int [] nums = new int[]{-1,0,3,5,9,12};
        Search_704 search_704 = new Search_704();
        int search = search_704.search(nums, 9);
        System.out.println(search);
    }
}
