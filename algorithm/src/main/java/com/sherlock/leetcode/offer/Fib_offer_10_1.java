package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/2/6 11:29
 *
 * @Version 1.0
 * @Note
 */
public class Fib_offer_10_1 {
    public int fib(int n) {
        if (n == 1|| n==0){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fib_offer_10_1 fib_offer_10_1  = new Fib_offer_10_1();
        int fib = fib_offer_10_1.fib(45);
        System.out.println(fib);
    }
}
