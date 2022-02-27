package com.sherlock.leetcode.offer;

import java.util.EnumSet;
import java.util.PriorityQueue;

/**
 * @author Sherlock
 * @date 2022/2/14 11:30
 * @describe
 */
public class GetLeastNumbers_offer_40 {
    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int length = arr.length;
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < length; i++) {
            if (queue.size()<k){
                queue.offer(arr[i]);
            }else if (arr[i]<queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()){
                result[i]= queue.poll();
            }
        }
        return result;
    }
}
