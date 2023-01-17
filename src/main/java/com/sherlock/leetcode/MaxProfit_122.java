package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/7 11:49
 * @describe 买股票的最佳时机II 可以买卖多次 ,但手里持有时无法买入
 */
public class MaxProfit_122 {

    public int maxProfit(int[] prices) {
        int currMin = prices[0];
        int max = 0;
        for (int price : prices) {
            if (0 < price - currMin) {
                max = Math.max(max, max + price - currMin);
            }
            currMin = price;
        }
        return max;
    }


    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        MaxProfit_122 maxProfit122 = new MaxProfit_122();
        int i = maxProfit122.maxProfit(prices);
        System.out.println(i);
    }
}
