package com.sherlock.leetcode;

import java.util.Arrays;

/**
 * @author Sherlock
 * @date 2021/12/21 11:48
 * @describe
 */
public class KMP {
    public static void main(String[] args) {
        String[] strings = {"dsads","dsaqwe","dsda"};
        Arrays.sort(strings);
        int minLength = strings[0].length();
        int maxLength = strings[strings.length-1].length();
        //获取最小长度
        int num = Math.min(maxLength, minLength);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (strings[0].charAt(i) == strings[strings.length - 1].charAt(i)) {
                stringBuilder.append(strings[0].charAt(i));
            } else{
                break;
            }
        }
        System.out.println(stringBuilder);
    }


    public void longestPalindrome(String str){
        int length = str.length();
        int stringBuffer = Integer.parseInt(null);
        for (int i = 0; i < length; i++) {
            stringBuffer = str.charAt(i) ^ stringBuffer;
        }
    }
}
