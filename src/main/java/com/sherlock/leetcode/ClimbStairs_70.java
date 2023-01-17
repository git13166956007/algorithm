package com.sherlock.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sherlock
 * @date 2022/10/8 17:18
 * @node
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 **/
public class ClimbStairs_70 {

    /**
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     *
     *
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(2);
        for (int i = 2; i <=n ; i++) {
            int i1 = dp.get(i - 2) + dp.get(i - 1);
            dp.add(i1);
        }
        return dp.get(n-1);
    }

    public static void main(String[] args) {
        ClimbStairs_70 climbStairs_70 = new ClimbStairs_70();
        int i = climbStairs_70.climbStairs(3);
        System.out.println(i);
    }
}
