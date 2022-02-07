package com.sherlock.leetcode;

/**
 * Created by Sherlock on 2022/1/25 20:11
 *
 * @Version 1.0
 * @Note
 */
public class ReverseString_344 {

    /**
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * @param s
     *
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     */
    public void reverseString(char[] s) {
        int len = s.length;
        int low = 0;
        int high = len - 1 ;
        while (low<high){
            s[low] ^= s[high];
            s[high]^= s[low] ;
            s[low] ^= s[high];
            low ++;
            high --;
        }
    }

    public static void main(String[] args) {
        char [] nums = new char[]{'h','e','l','l','o'};
        ReverseString_344 reverseString_344 = new ReverseString_344();
        reverseString_344.reverseString(nums);
    }
}
