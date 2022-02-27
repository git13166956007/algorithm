package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/2/16 9:31
 * @describe
 */
public class CuttingRope_offer_14_1 {

    public int cuttingRope(int n) {
        if (n<=3){
            return n-1;
        }
        int sum= 1;
        while (n>4){
            sum*=3;
            n-=3;
        }
        return sum;
    }
}
