package com.sherlock.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Sherlock
 * @date 2022/1/21 17:25
 * @describe
 */
public class ReversePrint_offer_06 {

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        int size = 0;
        while (head!=null){
            stack.push(head.val);
            head = head.next;
            size++;
        }
        int[] result = new int[size];
        for (int i = size-1; i > 0 ; i--) {
            result[i] = stack.pop();
        }
//        List<Integer> list = new ArrayList<>();
//        while (!stack.isEmpty()){
//            list.add(stack.pop());
//        }
//        return list.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
