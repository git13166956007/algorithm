package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/10/19 15:30
 * @note
 **/
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
//        int[] factors = {2, 3, 5};
//        Set<Long> seen = new HashSet<>();
//        PriorityQueue<Long> heap = new PriorityQueue<Long>();
//        seen.add(1L);
//        heap.offer(1L);
//        int ugly = 0;
//        for (int i = 0; i < n; i++) {
//            long curr = heap.poll();
//            ugly = (int) curr;
//            for (int factor : factors) {
//                long next = curr * factor;
//                if (seen.add(next)) {
//                    heap.offer(next);
//                }
//            }
//        }
//        return ugly;

        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        int i = nthUglyNumber.nthUglyNumber(11);
        System.out.println(i);
    }
}
