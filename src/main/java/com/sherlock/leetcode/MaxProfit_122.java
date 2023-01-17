package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/7 11:49
 * @describe 买股票的最佳时机II 可以买卖多次 ,但手里持有时无法买入
 */
public class MaxProfit_122 {

    public int maxProfit(int[] prices) {

        //记录最大收益
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {

            if (prices[i]<prices[i+1]){
                maxProfit += prices[i+1]-prices[i];
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        MaxProfit_122 maxProfit122 = new MaxProfit_122();
        int i = maxProfit122.maxProfit(prices);
        System.out.println(i);
    }
}
