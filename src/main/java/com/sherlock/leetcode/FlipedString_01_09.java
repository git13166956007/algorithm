package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/9/29 16:51
 * @node
 *
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 *
 **/
public class FlipedString_01_09 {

    /**
     *  输入：s1 = "waterbottle", s2 = "erbottlewat"
     *  输出：True
     *
     *   输入：s1 = "aa", s2 = "aba"
     *  输出：False
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        return s1.length()==s2.length()||(s1+s1).contains(s2);
    }
}
