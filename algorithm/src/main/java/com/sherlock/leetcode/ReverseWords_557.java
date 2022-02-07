package com.sherlock.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Sherlock on 2022/1/25 20:24
 *
 * @Version 1.0
 * @Note
 */
public class ReverseWords_557 {

    public String reverseWords1(String s) {
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder(len);
        Stack<Character> list = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == ' '){
                while (!list.isEmpty()){
                    stringBuilder.append(list.pop());
                }
                stringBuilder.append(c);
            } else if ( i == len-1){
                stringBuilder.append(c);
                while (!list.isEmpty()){
                    stringBuilder.append(list.pop());
                }
            }else {
                list.add(c);
            }
        }
        return stringBuilder.toString();
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ' ){
                right = i -1 ;
                swap(chars,left,right);
                left = i + 1;
            }
            if (i == len -1 ){
                right = i ;
                swap(chars,left,right);
                left = i + 1;
            }
        }
        return new String(chars);
    }

    public void swap(char[] chars,int left,int right ){
        while (left<right){
            chars[left]^=chars[right];
            chars[right]^=chars[left];
            chars[left]^=chars[right];
            right --;
            left ++;
        }
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWords_557 reverseWords_557 = new ReverseWords_557();
        String s1 = reverseWords_557.reverseWords(s);
        System.out.println(s1);


    }
}
