package com.sherlock.leetcode;

import java.util.Arrays;

/**
 * @author sherlock
 * @date 2022/10/14 10:06
 * @node
 *
 * 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
 *
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
 *
 * 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/distinct-subsequences-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class DistinctSubseqII {


    /**
     * 输入：s = "abc"
     * 输出：7
     * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
     *
     *
     *
     * 输入：s = "aba"
     * 输出：6
     * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
     *
     * 输入：s = "aaa"
     * 输出：3
     * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
     *
     *
     *     小写字母，非空子序列，其中一类比较特殊的子序列，abc 包含 ac
     *     dp[i][j] 表示当前第i个位置，以j（s[i] - 'a'）结尾的方案数量有多少
     *     思路：
     *     1、当前位置新添加字符的不同子序列方案数 = 前面所一个字符方案数+1，也就是说匹配到当前字符方案数dp[i] = sum[i - 1] + 1
     *     2、题目要求需要不同的子字符串，所以当前的总方案数还需要减去之前重复的方案数，此时dp[i] = sum[i - 1] + 1 - preSum(j)
     *     这里dp可以用作一个常数dp表示，sum[j]也就是用作常数count表示，preSum则使用一个二维数组preSum[]来表示，记录对应字符所匹配的数量
     * @param s
     * @return
     */
    public int distinctSubseqII(String s) {
        final int mod = 1000000007;
        int n = s.length();
        char[] chars = s.toCharArray();
        int [][] dp = new int[n][26];
        dp[0][s.charAt(0)-'a'] = 1;
        for (int i = 1; i < chars.length; i++) {
            dp[i] = dp[i-1].clone();
            dp[i][chars[i]-'a'] =  (Arrays.stream(dp[i-1]).sum()+1)%mod;
        }
        return Arrays.stream(dp[n - 1]).sum() % mod;





/*
        long [] perSum = new long[26];
        long count = 1,dp = 0;
        for (char aChar : chars) {
            int index = aChar-'a';
            dp = (count - perSum[index] + mod)%mod;
            perSum[index] = (perSum[index] + dp + mod)%mod;
            count = (count + dp + mod)%mod;
        }
        return (int) count;
*/
    }

    public static void main(String[] args) {
        System.out.println(10^9);
    }
}
