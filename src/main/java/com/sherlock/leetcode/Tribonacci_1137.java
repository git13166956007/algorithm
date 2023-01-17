package com.sherlock.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sherlock
 * @date 2022/10/8 16:39
 * @node
 *
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class Tribonacci_1137 {

    /**
     * 输入：n = 4
     * 输出：4
     * 解释：
     * T_3 = 0 + 1 + 1 = 2
     * T_4 = 1 + 1 + 2 = 4
     *
     *
     * 输入：n = 25
     * 输出：1389537
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(1);
        for (int i = 3; i <= n; i++) {
            int i1 = integers.get(i - 3) + integers.get(i - 2) + integers.get(i - 1);
            integers.add(i1) ;
        }
        return integers.get(n);

    }


    public static void main(String[] args) {
        Tribonacci_1137 tribonacci_1137 = new Tribonacci_1137();
        int tribonacci = tribonacci_1137.tribonacci(25);
        System.out.println(tribonacci);
    }
}
