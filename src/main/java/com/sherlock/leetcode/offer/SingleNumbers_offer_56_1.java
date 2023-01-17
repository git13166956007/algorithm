package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/2/16 11:07
 * @describe
 */
public class SingleNumbers_offer_56_1 {

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     *
     * 输入：nums = [1,2,10,4,1,4,3,3]
     * 输出：[2,10] 或 [10,2]
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        //奇数偶数分组
        int k = 0;
        for (int num : nums){
            k ^= num;
        }
        int mark = 1;
        while ((k&mark)==0){
            mark <<= 1;
        }
        int a = 0,b = 0;
        for (int num: nums){
            if ((num&mark)==0){
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }

}
