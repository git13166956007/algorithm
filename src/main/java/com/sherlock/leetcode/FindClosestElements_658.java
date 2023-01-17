package com.sherlock.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sherlock
 * @date 2022/8/26 9:47
 * @node
 *
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 **/
public class FindClosestElements_658 {


    /**
     * 输入：arr = [1,2,3,4,5], k = 4, x = 3
     * 输出：[1,2,3,4]
     *
     *
     *
     * 输入：arr = [1,2,3,4,5], k = 4, x = -1
     * 输出：[1,2,3,4]
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>(k);
        int length = arr.length;
        //1、二分法找x的插入点
        int index = binarySearch(arr, x);
        if (index == 0){
            //说明是从第一位开始插入即可
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
        }else {
            //2、双指针扩散(需要判断边界) 需要用绝对值比较
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
            int left = index;
            int right = index;
            while (priorityQueue.size() < k ){
                if (priorityQueue.size()==0){
                    priorityQueue.add(arr[index]);
                }else {
                    if (left > 0){
                        priorityQueue.add(arr[--left]);
                    }
                    if (priorityQueue.size() < k&&right < length-1){
                        priorityQueue.add(arr[++right]);
                    }
                }
            }
            while (!priorityQueue.isEmpty()) {
                Integer poll = priorityQueue.poll();
                result.add(poll);
            }
        }
        return result;
    }

    private int binarySearch(int[] arr, int x){
        int length = arr.length;
        int left = 0;
        int right = length-1;
        while (left< right){
            int mid = left+ ((right-left)>>1);
            if (x<= arr[mid]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,1,2,3,6,7,8,9};
        int k = 9;
        int x = 4;
        FindClosestElements_658 findClosestElements_658 = new FindClosestElements_658();
        List<Integer> closestElements = findClosestElements_658.findClosestElements(arr, k, x);
        System.out.println(closestElements);
    }
}
