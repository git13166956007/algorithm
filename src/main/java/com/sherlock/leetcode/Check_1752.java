package com.sherlock.leetcode;

import java.util.Arrays;

/**
 * @author sherlock
 * @date 2022/9/29 17:07
 * @node
 *
 * 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
 *
 * 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
 *
 * 源数组中可能存在 重复项 。
 *
 * 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class Check_1752 {

    /**
     * 输入：nums = [3,4,5,1,2]
     * 输出：true
     * 解释：[1,2,3,4,5] 为有序的源数组。
     * 可以轮转 x = 3 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 输入：nums = [2,1,3,4]
     * 输出：false
     * 解释：源数组无法经轮转得到 nums 。
     *
     * 输入：nums = [1,2,3]
     * 输出：true
     * 解释：[1,2,3] 为有序的源数组。
     * 可以轮转 x = 0 个位置（即不轮转）得到 nums 。
     *
     *
     * @param nums
     * @return
     */
    public boolean check(int[] nums) {
        StringBuilder target = new StringBuilder();
        for (int num : nums) {
            target.append(num);
            target.append(",");
        }
        String ta = target.toString();
        Arrays.sort(nums);
        StringBuilder sourceDouble = new StringBuilder();
        for (int num : nums) {
            sourceDouble.append(num);
            sourceDouble.append(",");
        }
        String sd = sourceDouble.toString();
        return ta.length()== sd.length()&&(sd+sd).contains(ta);
    }
}
