package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/2/15 10:02
 * @describe
 */
public class Add_offer_65 {

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b!=0){
            int c = (a&b)<< 1;
            a^=b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        while (b!=0){
            int c = (a&b)<< 1;
            a^=b;
            b = c;
        }
        System.out.println(a);

        System.out.println(a&b);
        System.out.println(a|b);
        System.out.println(a^b);
    }

}
