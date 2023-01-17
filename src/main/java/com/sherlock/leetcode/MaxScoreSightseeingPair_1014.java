package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/10/13 11:05
 * @node
 *
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 **/
public class MaxScoreSightseeingPair_1014 {

    /**
     * 输入：values = [8,1,5,2,6]
     * 输出：11
     * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
     *
     *
     *
     * 输入：values = [1,2]
     * 输出：2
     *
     *
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int length = values.length;
        int max = Integer.MIN_VALUE;
        int maxLeft = values[0];
        int left = 1;
        while (left<length){
            // values[i]+i + values[j]-i
            max = Math.max(max,maxLeft+ values[left]-left);
            maxLeft = Math.max(values[left]+left,maxLeft);
            left++;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxScoreSightseeingPair_1014 maxScoreSightseeingPair_1014 = new MaxScoreSightseeingPair_1014();
        int i = maxScoreSightseeingPair_1014.maxScoreSightseeingPair(new int[]{4,7,5,8});
        System.out.println(i);
    }
}
