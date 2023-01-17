package com.sherlock.leetcode;

import java.util.List;

/**
 * @author sherlock
 * @date 2022/11/11 16:18
 * @note
 **/
public class HalvesAreAlike_1704 {

    /**
     *
     * @param s
     * @return
     */
    public boolean halvesAreAlike(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int left = 0;
        int right = length-1;
        List<Character> dic = List.of('a','e','i','o','u','A','E','I','O','U');
        int leftCount = 0;
        int rightCount = 0;
        while (left<right){
            if(dic.contains(chars[left])){
                leftCount++;
            }
            left++;
            if(dic.contains(chars[right])){
                rightCount++;
            }
            right--;
        }
        return leftCount == rightCount;
    }
}
