package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/10/10 15:24
 * @node
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class CanJump_55 {

    /**
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *
     *
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/jump-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; ++i) {
            if (index<i){
                return false;
            }
            index = Math.max(index, i + nums[i]);
            if (index >= n - 1) {
                return true;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        CanJump_55 canJump_55 = new CanJump_55();
        boolean b = canJump_55.canJump(new int[]{2,5,0,0});
        System.out.println(b);
    }
}
