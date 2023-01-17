package com.sherlock.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Sherlock on 2022/1/23 22:05
 *
 * @Version 1.0
 * @Note
 */
public class Rotate_189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 1){
            return;
        }
        k %=len;
        int index = 0;
        int [] result = nums.clone();
        for(int i = len -k ;i< len; i++){
            nums[index++] = result[i];
        }
        for(int i = 0 ;i< len-k; i++){
            nums[index++] = result[i];
        }
        Arrays.stream(nums).forEach(System.out::print);
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        Rotate_189 rotate_189 = new Rotate_189();
        rotate_189.rotate(nums,k);
    }
}
