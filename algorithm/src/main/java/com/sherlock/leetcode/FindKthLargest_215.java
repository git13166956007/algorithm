package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/5 15:28
 * @describe 数组中的第K个最大元素
 */
public class FindKthLargest_215 {

    //首先需要进行排序(直接倒叙排列)
    //然后找出第K个元素即可 3,2,3,1,2,4,5,5,6  1,2,2,3,3,4,5,5,6

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (k<=0|| k>nums.length){
            throw new IllegalArgumentException("参数无效");
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                //与下一个比较
                if (nums[j]<nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums[k-1];
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,3,1,2,4,5,5,6};
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        FindKthLargest_215 kthLargest = new FindKthLargest_215();
        int kthLargest1 = kthLargest.findKthLargest(nums, k);
        System.out.println(kthLargest1);
    }
}
