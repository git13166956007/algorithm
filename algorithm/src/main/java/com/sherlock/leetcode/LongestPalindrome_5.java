package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2021/12/21 15:21
 * @describe
 */
public class LongestPalindrome_5 {

    /**
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s==null ||s.length()==0 ){
            return null;
        }
        if (s.length()==1||s.length()==2&&s.charAt(0)==s.charAt(1)){
            return s;
        }
        //中心扩散
        //分偶数长度回文  和    奇数长度回文
        int left;
        int right;
        int length = s.length();
        int len = 1;
        int maxLen = 0;
        int maxStart = 0;
        for (int i = 0; i < length; i++) {
            left = i-1;right = i+1;
            //左边
            while (left >=0 && s.charAt(i) == s.charAt(left)){
                len++;
                left--;
            }
            //右边
            while (right <=length-1 && s.charAt(i) == s.charAt(right)){
                len++;
                right++;
            }
            //中间
            while (left >=0 && right <=length-1 && s.charAt(left) == s.charAt(right)){
                len+=2;
                left--;
                right++;
            }
            if (len>maxLen){
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }

        return s.substring(maxStart+1,maxStart+maxLen+1);
    }

    public static void main(String[] args) {
        String aa = "babadaaaadd";
        LongestPalindrome_5 longestPalindrome5 = new LongestPalindrome_5();
        String s = longestPalindrome5.longestPalindrome(aa);
        System.out.println(s);
    }
}
