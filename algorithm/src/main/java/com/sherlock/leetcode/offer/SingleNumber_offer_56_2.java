package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/2/16 14:30
 * @describe
 */
public class SingleNumber_offer_56_2 {

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     *
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }


    public static void main(String[] args) {
        SingleNumber_offer_56_2 singleNumber_offer_56_2 = new SingleNumber_offer_56_2();
        int i = singleNumber_offer_56_2.singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7});
        System.out.println(i);
    }
}
