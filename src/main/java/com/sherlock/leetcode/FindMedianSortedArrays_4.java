package com.sherlock.leetcode;

import java.util.Arrays;

/**
 * @author sherlock
 * @date 2022/9/30 15:10
 * @node
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/
public class FindMedianSortedArrays_4 {

    /**
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     *
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //元素插入、 二分法查找
        int length = nums1.length;
        int[] ints = Arrays.copyOf(nums1, nums1.length + nums2.length);
        for (int j : nums2) {
            ints[length++] = j;
        }
        Arrays.sort(ints);
        //判断奇偶，如果为奇数，直接返回长度折半（向上取整）的值
        //如果为偶数，则直接返回长度折半和折半+1的值/2的数即为结果
        int i = ints.length / 2;
        if ((ints.length&1)==0){
            //偶数
            return (double) (ints[i]+ints[i-1])/2;
        }else {
            //奇数
            return (ints[i]);
        }

    }

    public static void main(String[] args) {
//        FindMedianSortedArrays_4 findMedianSortedArrays_4 = new FindMedianSortedArrays_4();
//        double medianSortedArrays = findMedianSortedArrays_4.findMedianSortedArrays(new int[]{1,3}, new int[]{2,4});
//        System.out.println(medianSortedArrays);


        System.out.println(8%5);
    }

}
