package com.sherlock.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sherlock
 * @date 2022/1/19 17:08
 * @describe
 */
public class MergeTwoLists_21 {
    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //制造小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
        while (list1!=null){
            priorityQueue.offer(list1.val);
            list1 = list1.next;
        }
        //塞进去
        while (list2!=null){
            priorityQueue.offer(list2.val);
            list2 = list2.next;
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

    public static void main(String[] args) {
        MergeTwoLists_21 mergeTwoLists_21 = new MergeTwoLists_21();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode4 = new ListNode(4);
        listNode2.next = listNode4;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode33 = new ListNode(3);
        listNode11.next = listNode33;
        ListNode listNode44 = new ListNode(4);
        listNode33.next = listNode44;
        ListNode listNode = mergeTwoLists_21.mergeTwoLists(listNode1, listNode11);
        System.out.println(listNode);
    }
}
