package com.sherlock.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Sherlock on 2022/1/26 10:06
 *
 * @Version 1.0
 * @Note
 */
public class LengthOfLongestSubstring_3 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * @param s
     * @return
     *
     * 滑动窗口 解法
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int maxLen = 0;
        Map<Character,Integer> windows = new HashMap<>();
        int left = 0;
        for (int i = 0; i < len; i++) {
            if(windows.containsKey(chars[i])){
                left = Math.max(left,windows.get(chars[i])+1);
            }
            windows.put(chars[i],i);
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String s = "dvdf";
        LengthOfLongestSubstring_3 len = new LengthOfLongestSubstring_3();
        int i = len.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
