package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/1/23 16:21
 *
 * @Version 1.0
 * @Note
 */
public class ReverseLeftWords_offer_58 {

    public String reverseLeftWords(String s, int n) {
        int len  = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < len; i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        int n = 6;
        ReverseLeftWords_offer_58 reverseLeftWords_offer_58 = new ReverseLeftWords_offer_58();
        String r = reverseLeftWords_offer_58.reverseLeftWords(s,n);
        System.out.println(r);
    }
}
