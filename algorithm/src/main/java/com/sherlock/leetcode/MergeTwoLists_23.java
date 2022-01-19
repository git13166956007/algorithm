package com.sherlock.leetcode;

import java.util.PriorityQueue;

/**
 * @author Sherlock
 * @date 2022/1/19 17:08
 * @describe
 */
public class MergeTwoLists_23 {

    public ListNode mergeTwoLists(ListNode[] lists) {
        //制造小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
        for (ListNode list : lists) {
            while (list!=null){
                priorityQueue.offer(list.val);
                list = list.next;
            }
        }
        ListNode current = null;
        ListNode next = null;
        while (!priorityQueue.isEmpty()){
            Integer poll = priorityQueue.poll();
            current = new ListNode(poll);
            current.next = next;
            next = current;
        }
        return current;
    }
      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
