package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/10/19 17:31
 * @note
 **/
public class NumTrees_96 {

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            for(int j = 1; j < i + 1; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumTrees_96 numTrees_96 = new NumTrees_96();
        int i = numTrees_96.numTrees(4);
        System.out.println(i);
    }
}
