package com.sherlock.leetcode;

/**
 * Created by Sherlock on 2022/1/25 13:34
 *
 * @Version 1.0
 * @Note
 */
public class MoveZeroes_283 {

    /**
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 1、必须在原数组上操作，不能拷贝额外的数组。
     * 2、尽量减少操作次数。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i]!=0){
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < len ;i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,0};
        MoveZeroes_283 moveZeroes_283 = new MoveZeroes_283();
        moveZeroes_283.moveZeroes(nums);
    }
}
