package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/10/10 16:43
 * @node
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 **/
public class JumpII_45 {


    /**
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     *
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums){
        int length = nums.length;
        int end = 0;
        int max = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpII_45 jumpII_45 = new JumpII_45();
        int jump = jumpII_45.jump(new int[]{2, 0, 1, 1, 4});
        System.out.println(jump);
    }
}
