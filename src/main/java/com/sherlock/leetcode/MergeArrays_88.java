package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/8/23 10:04
 * @node
 *
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class MergeArrays_88 {

    /**
     *输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0, i = 0;
        int[] temp = new int[m + n];
        if (m == 0) {
            System.arraycopy(nums2, 0, temp, 0, m + n);
        }
        if (n == 0) {
            System.arraycopy(nums1, 0, temp, 0, m + n);
        }
        while ((p1 <= m || p2 < n) && i < m + n) {
            if (nums1[p1] < nums2[p2]) {
                temp[i++] = nums1[p1++];
            } else {
                temp[i++] = nums2[p2++];
            }
        }
        System.arraycopy(temp, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        MergeArrays_88 mergeArrays_88 = new MergeArrays_88();
        mergeArrays_88.merge(nums1,3,nums2,3);
        System.out.println(nums1);
    }
}
