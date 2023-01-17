package com.sherlock.leetcode;

import java.util.Stack;

/**
 * @author sherlock
 * @date 2022/10/9 11:50
 * @node
 *
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class ScoreOfParentheses_856 {


    /**
     * 输入： "()"
     * 输出： 1
     *
     *
     * 输入： "(())"
     * 输出： 2
     *
     * 输入： "()()"
     * 输出： 2
     *
     *
     * @param s
     * @return
     */
    public int scoreOfParentheses(String s) {
//        int length=s.length();
//        int sum=0;
//        int n=0;
//        for(int i=0;i<length;i++) {
//            if(s.charAt(i)=='(') {
//                if(n==0) {
//                    n=1;
//                } else {
//                    n=n<<1;
//                }
//            } else if(s.charAt(i)==')') {
//                if(s.charAt(i-1)=='(') {
//                    sum+=n;
//                }
//                n=n>>1;
//            }
//        }
//        return sum;

        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else {
                stack.pop();
            }
            if (s.charAt(i)==')' && s.charAt(i-1)=='('){
                sum+= 1<<stack.size();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ScoreOfParentheses_856 scoreOfParentheses_856 = new ScoreOfParentheses_856();
        int i = scoreOfParentheses_856.scoreOfParentheses("(((())))()");
        System.out.println(i);
    }
}
