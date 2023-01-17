package com.sherlock.leetcode.offer;

import java.util.Stack;

/**
 * @author Sherlock
 * @date 2022/2/16 14:53
 * @describe
 */
public class ValidateStackSequences_offer_31 {

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     *
     * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
     * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     *
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     *
     *
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        int len = pushed.length;
//        if (pushed.length != popped.length){
//            return false;
//        }
//        int[] stack = new int[len];
//        int stackIndex = 0;
//        int index = 0;
//        for (int i : pushed) {
//            stack[stackIndex++] = i;
//            while (stackIndex > 0 &&( stack[stackIndex-1] ==popped[index])){
//                index++;
//                stackIndex--;
//            }
//        }
//        return stackIndex == 0;

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        ValidateStackSequences_offer_31 validateStackSequences_offer_31 = new ValidateStackSequences_offer_31();
        validateStackSequences_offer_31.validateStackSequences(pushed,popped);
    }

}
