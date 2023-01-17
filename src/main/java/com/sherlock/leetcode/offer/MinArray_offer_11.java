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
     *
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     *
     * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
     *
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length -1;
        while (low <=high){
            int mid = (low+high)>>1;
            //如果最右边的值小于当前中间值，说明最小值在中间值的右边,把left = mid+1
            if (numbers[mid]>numbers[high]){
                low = mid + 1;
            }else if (numbers[mid]<numbers[high]){
                high = mid;
            }else {
                high--;
            }
        }
        return numbers[low];
    }


    public static void main(String[] args) {
        MinArray_offer_11 offer_11 = new MinArray_offer_11();
        int i = offer_11.minArray(new int[]{2,2,2,2,2,2,2,0,1,2,3});
        System.out.println(i);
    }
}
