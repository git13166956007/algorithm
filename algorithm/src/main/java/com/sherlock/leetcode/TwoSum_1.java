package com.sherlock.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * <p>
 * Easy
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * My thoughts:
 *
 * @author KronChan
 * @version 1.0
 * @since <pre>2017/12/20 22:49</pre>
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }
        // complexity O (n^2)
//        for (int i = 0, len = nums.length; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
        throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        TwoSum_1 twoSum1 = new TwoSum_1();
        int[] ints = twoSum1.twoSum(nums, target);
        System.out.println(ints);
    }
}
