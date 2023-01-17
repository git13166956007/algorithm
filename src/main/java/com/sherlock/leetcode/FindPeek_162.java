package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/8/13 0013 22:58
 * @describe
 *
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindPeek_162 {

    /**
     * 输入：nums = [1,2,3,1]
     * 输出：2
     * 解释：3 是峰值元素，你的函数应该返回其索引 2。
     *
     * 输入：nums = [1,2,1,3,5,6,4]
     * 输出：1 或 5
     * 解释：你的函数可以返回索引 1，其峰值元素为 2；
     *      或者返回索引 5， 其峰值元素为 6。
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = left + (right - left)/2;
            //如果当前大于下一个，那么降序排列，肯定左边存在峰值，将right = mid； 否则为右边存在峰值
            if (nums[mid+1]<nums[mid]){
                right =  mid ;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindPeek_162 findPeek_162 = new FindPeek_162();
        int peakElement = findPeek_162.findPeakElement(new int[]{1,2,3,1});
        System.out.println(peakElement);
    }
}
