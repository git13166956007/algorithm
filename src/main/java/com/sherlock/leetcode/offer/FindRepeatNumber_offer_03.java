package com.sherlock.leetcode.offer;

import java.util.*;

/**
 * Created by Sherlock on 2022/1/23 16:50
 *
 * @Version 1.0
 * @Note
 */
public class FindRepeatNumber_offer_03 {

    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length;i++){
            if (temp!=nums[i]){
                temp = nums[i];
            }else {
                return temp;
            }
        }
        return -1;
    }

}
