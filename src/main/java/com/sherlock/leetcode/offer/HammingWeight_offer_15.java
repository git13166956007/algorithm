package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/2/14 18:09
 * @describe
 */
public class HammingWeight_offer_15 {
    public int hammingWeight(int n){
        int result = 0;
        while (n != 0){
            result+= n&1;
            n>>>=1;
        }
        return result;
    }


    public static void main(String[] args) {
        HammingWeight_offer_15 hammingWeight_offer_15 = new HammingWeight_offer_15();
        int i = hammingWeight_offer_15.hammingWeight(5);
        System.out.println(i);
    }
}
