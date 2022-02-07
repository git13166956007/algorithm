package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/2/6 11:59
 *
 * @Version 1.0
 * @Note 青蛙跳台问题
 */
public class numWays_offer_10_2 {

    /**
     *一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
     * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     *
     *
     *
     * @param n n级台阶
     * @return 一共多少种跳法
     */
    public int numWays(int n) {
        //n == 1 时就 1种 只能跳1次1层
        //n == 2 时就 2种 1次2层或者 2次1层
        //n == 3 时就 3种，3次1层 ，1次1层外加1次2层
        if (n<3){
            return n;
        }
        //大于等于3层时，会有不同的组合情况
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-2]+dp[i-1])%1000000007;
        }
        return dp[n];
    }
}
