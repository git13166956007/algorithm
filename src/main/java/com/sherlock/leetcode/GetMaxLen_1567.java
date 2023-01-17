package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/10/12 16:12
 * @node
 *
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 *
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 *
 * 请你返回乘积为正数的最长子数组长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-length-of-subarray-with-positive-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class GetMaxLen_1567 {

    /**
     *输入：nums = [1,-2,-3,4]
     * 输出：4
     * 解释：数组本身乘积就是正数，值为 24 。
     *
     *
     *
     * 输入：nums = [0,1,-2,-3,-4]
     * 输出：3
     * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
     * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
     *
     *
     *
     * 输入：nums = [-1,-2,-3,0,1]
     * 输出：2
     * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3]
     *
     *
     * @param nums
     * @return
     */
    public int getMaxLen(int[] nums) {

       int result = 0;
       int z = 0, f = 0;
        for (int num : nums) {
            if (num==0){
                z = 0;
                f = 0;
            }else if (num>0){
                z++;
                if (f>0){
                    f++;
                }
                result = Math.max(result,z);
            }else {
                z^=f;
                f^=z;
                z^=f;
                f++;
                if (z>0){
                    z++;
                }
                result = Math.max(result,z);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        GetMaxLen_1567 getMaxLen_1567 = new GetMaxLen_1567();
        int maxLen = getMaxLen_1567.getMaxLen(new int[]{-1,-2,-3,0,1});
        System.out.println(maxLen);
    }
}
