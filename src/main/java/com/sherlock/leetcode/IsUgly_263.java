package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/10/19 16:42
 * @note
 **/
public class IsUgly_263 {

    public boolean isUgly(int n) {
        if(n<=1) {
            return n == 1;
        }
        while(n>1){
            int t = n;
            while(t%2==0) {
                t/=2;
            }
            while(t%3==0) {
                t/=3;
            }
            while(t%5==0) {
                t/=5;
            }
            if(t == n) {
                return false;
            }
            n = t;
        }
        return true;
    }

    public static void main(String[] args) {
        IsUgly_263 isUgly_263 = new IsUgly_263();
        boolean ugly = isUgly_263.isUgly(8);
        System.out.println(ugly);
    }
}
