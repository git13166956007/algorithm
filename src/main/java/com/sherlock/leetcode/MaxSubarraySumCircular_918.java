package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/10/11 17:24
 * @node
 *
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 *
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-sum-circular-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxSubarraySumCircular_918 {


    /**
     * 输入：nums = [1,-2,3,-2]
     * 输出：3
     * 解释：从子数组 [3] 得到最大和 3
     *
     * 输入：nums = [5,-3,5]
     * 输出：10
     * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
     *
     * 输入：nums = [3,-2,2,-3]
     * 输出：3
     * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
     *
     *
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
//        int[] sum = new int[nums.length*2];
//        for (int i = 0; i < nums.length*2; i++) {
//            sum[i] = nums[i%nums.length];
//        }
//        List<Integer> list = new ArrayList<>();
//        list.add(nums[0]);
//        for (int i = 0; i < sum.length; i++) {
//            for (int j = i+1; j < sum.length; j++) {
//                if (j-i<nums.length){
//                    if (list.get(list.size()-1)<=0){
//                        list.add(sum[j]);
//                    }else {
//                        list.add(sum[j] + list.get(list.size()-1));
//                    }
//                }else {
//                    break;
//                }
//            }
//        }
//        int max = Integer.MIN_VALUE;
//        for (Integer integer : list) {
//            max = Math.max(max, integer);
//        }
//        return max;



        int maxSum=nums[0];
        int len=nums.length;
        int dp;
        for (int i = 0; i < nums.length; i++) {
            int tmpIndex=0;
            dp=nums[i];
            for (int j = i+1; tmpIndex<len-1; j++) {
                tmpIndex++;
                dp=Math.max(dp+nums[j%len], nums[j%len]);
                maxSum=Math.max(dp, maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubarraySumCircular_918 maxSubarraySumCircular_918 = new MaxSubarraySumCircular_918();
        int i = maxSubarraySumCircular_918.maxSubarraySumCircular(new int[]{1,-2,3,-2});
        System.out.println(i);
    }
}
