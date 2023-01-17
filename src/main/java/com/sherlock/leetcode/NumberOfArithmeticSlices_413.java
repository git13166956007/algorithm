package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/10/21 9:55
 * @note
 *
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/
public class NumberOfArithmeticSlices_413 {


    /**
     *输入：nums = [1,2,3,4]
     * 输出：3
     * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
     *
     *
     * 输入：nums = [1]
     * 输出：0
     *
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n<3){
            return 0;
        }
        int index = 0;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i-1]-nums[i-2]==nums[i]-nums[i-1]){
                sum+=++index;
            }else {
                index=0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOfArithmeticSlices_413 numberOfArithmeticSlices_413 = new NumberOfArithmeticSlices_413();
        int i = numberOfArithmeticSlices_413.numberOfArithmeticSlices(new int[]{1,2,3,8,9,10});
        System.out.println(i);
    }
}
