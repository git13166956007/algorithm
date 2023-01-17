package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/1/23 16:15
 *
 * @Version 1.0
 * @Note
 */
public class ReplaceSpace_offer_05 {


    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
