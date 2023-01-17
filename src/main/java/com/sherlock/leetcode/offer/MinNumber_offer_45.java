package com.sherlock.leetcode.offer;

import java.util.Arrays;

/**
 * @author Sherlock
 * @date 2022/2/14 10:10
 * @describe
 */
public class MinNumber_offer_45 {
    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     *
     *  思路： 两个数看作是字符串一样 x+y > y+x 则排序为 yx,否则为xy
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        int length = nums.length;
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = nums[i]+"";
        }
        Arrays.sort(strings,(x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strings){
            res.append(s);
        }
        return res.toString();
    }
}
