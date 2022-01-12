package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/6 18:10
 * @describe 121 买卖股票的最佳时机 买一次 卖一次
 */
public class MaxProfit {

    /**
     * 只需要江
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        //最小价格
        int minPrice = Integer.MAX_VALUE;
        //最大收益
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            //判断是否为最大收益
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int i = maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}
