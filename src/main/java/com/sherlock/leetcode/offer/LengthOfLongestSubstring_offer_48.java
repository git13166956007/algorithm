package com.sherlock.leetcode.offer;

import com.sun.java.swing.plaf.windows.resources.windows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sherlock
 * @date 2022/2/8 10:29
 * @describe
 */
public class LengthOfLongestSubstring_offer_48 {
    /**
     *输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        Set<Character> windows = new HashSet<>();
        int result = 0;
        int l = 0;
        for (int i = 0; i < length; i++) {
            while (windows.contains(chars[i])){
                //清空至窗口中没有当前字符为止
                windows.remove(chars[l++]);
            }
            windows.add(chars[i]);
            result = Math.max(result, windows.size());
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_offer_48 lengthOfLongestSubstring_offer_48 = new LengthOfLongestSubstring_offer_48();
        int i = lengthOfLongestSubstring_offer_48.lengthOfLongestSubstring("abcabcdbb");
        System.out.println(i);
    }
}
