package com.sherlock.leetcode;
/**
 * @author Sherlock
 * @date 2022/2/7 14:06
 * @describe
 */
public class MaxValue_offer_47 {
    /**
     * 滚动数组解法
     * @param grid 图
     * @return 返回
     */
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[] dp = new int[columns+1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                dp[j] = Math.max(dp[j],dp[j-1])+ grid[i-1][j-1];
            }
        }
        return dp[columns];
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1},
        };
        MaxValue_offer_47 maxValue_offer_47 = new MaxValue_offer_47();
        maxValue_offer_47.maxValue(grid);
    }
}
