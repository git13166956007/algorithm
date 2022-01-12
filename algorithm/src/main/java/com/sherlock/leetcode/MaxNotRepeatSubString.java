package com.sherlock.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Sherlock
 * @date 2021/12/27 9:57
 * @describe 无重复字符最长子串(连续)
 */
public class MaxNotRepeatSubString {

    public static void main(String[] args) {
//        String str = "abcabcbb";
//        String str = "bbbbbb";
        String str = "pwwkew";
        //1、循环遍历每个字符
        //2、定义一个窗口数组
        //3、每次都将当前字符插入到窗口中，但每次插入之前需要判断是否当前字符在窗口中存在，如果存在则扔掉第一次加入的字符
        //FIFO 可以利用队列来当作窗口
        Map<Character, Integer> map = new HashMap<>(str.length());
        char[] chars = str.toCharArray();
        int answer = 0;
        for (int end = 0 ,start = 0; end < str.length(); end++) {
            char character = chars[end];
            if(map.containsKey(character)){
                start = Math.max(map.get(character), start);
            }
            answer = Math.max(answer, end - start + 1);
            map.put(character,end+1);
        }
        System.out.println(answer);
    }
}
