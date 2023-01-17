package com.sherlock.leetcode;

import java.util.Arrays;

/**
 * @author sherlock
 * @date 2022/10/9 15:35
 * @node
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 **/
public class Rob_198 {


    /**
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int p = nums[0];
        int q = nums[1];
        int s = 0;
        for (int i = 2; i < nums.length; i++) {
            s = Math.max(p+nums[i],q);
            p = q;
            q = s;
        }
        return s;
    }


    public int robII(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] ints = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] int2 = Arrays.copyOfRange(nums, 1, nums.length );
        return Math.max(dp(ints),dp(int2));
    }

    private int dp(int[] nums){
        int p = nums[0], q = Math.max(nums[0],nums[1]),s = 0;
        for (int i = 2; i < nums.length; i++) {
            s = Math.max(q,nums[i]+p);
            p = q;
            q = s;
        }
        return q;
    }

    public static void main(String[] args) {
        Rob_198 rob_198 = new Rob_198();
        int rob = rob_198.robII(new int[]{2,3,2});
        System.out.println(rob);
    }
}
