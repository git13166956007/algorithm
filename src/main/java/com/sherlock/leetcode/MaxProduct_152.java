package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/10/12 14:25
 * @node
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxProduct_152 {

    /**
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     *
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int length = nums.length;
        if (length==1){
            return nums[0];
        }
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < length; i++) {
            if(nums[i] < 0){
                max^=min;
                min^=max;
                max^=min;
            }
            max = Math.max(max*nums[i], nums[i]);
            min = Math.min(min*nums[i], nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxProduct_152 maxProduct_152 = new MaxProduct_152();
        int i = maxProduct_152.maxProduct(new int[]{-1,-2,-3,0,1});
        System.out.println(i);
    }
}
