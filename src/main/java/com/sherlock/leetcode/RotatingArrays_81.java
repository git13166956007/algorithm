package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/8/13 0013 22:04
 * @describe 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * 你必须尽可能减少整个操作步骤。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class RotatingArrays_81 {
    /**
     * 输入：nums = [2,5,6,0,0,1,2], target = 0
     * 输出：true
     *
     * 输入：nums = [2,5,6,0,0,1,2], target = 3
     * 输出：false
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        //思路：二分查询
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            //左边有序
            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 0;
        RotatingArrays_81 rotatingArrays_81 = new RotatingArrays_81();
        boolean search = rotatingArrays_81.search(nums, target);
        System.out.println(search);
    }
}
