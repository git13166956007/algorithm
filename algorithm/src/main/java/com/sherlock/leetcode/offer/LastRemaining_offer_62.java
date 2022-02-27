package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/2/16 15:33
 * @describe
 */
public class LastRemaining_offer_62 {

    public int lastRemaining(int n, int m) {


        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m)% i;
        }
        return result;
    }


    public int count1Number(int target){
        int a =0;
        while (target!=0){
            target &= (target-1);
            a++;
        }
        return a;
    }
    public static void main(String[] args) {

        LastRemaining_offer_62 lastRemaining_offer_62 = new LastRemaining_offer_62();
        int i = lastRemaining_offer_62.count1Number(34520);
        System.out.println(i);
    }
}
