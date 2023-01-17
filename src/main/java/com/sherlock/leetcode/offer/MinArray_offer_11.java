package com.sherlock.leetcode.offer;

import java.util.Arrays;

/**
 * Created by Sherlock on 2022/1/26 21:36
 *
 * @Version 1.0
 * @Note
 */
public class MinArray_offer_11 {
    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int len = numbers.length;
        int low = 0;
        int high = len -1;
        while (low <=high){
            int mid = (low+high)>>1;
            if (numbers[mid]<numbers[high]){
                high = mid - 1;
            }else if (numbers[mid]>numbers[high]){
                low = mid + 1;
            }else {
                --high;
            }
        }
        return numbers[low];
    }

}
