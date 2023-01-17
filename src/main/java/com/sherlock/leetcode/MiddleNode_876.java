package com.sherlock.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sherlock on 2022/1/25 21:21
 *
 * @Version 1.0
 * @Note
 */
public class MiddleNode_876 {

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        int index = 0;
        search(head,index,map);
        int size = map.size();
        return map.get(size / 2);
    }

    private void search(ListNode head,int index,Map<Integer,ListNode> map){
        if (head == null){
            return;
        }
        map.put(index,head);
        index++;
        search(head.next,index,map);
    }


    /**
     *  双指针解法
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int size = 4;

        System.out.println(size/2);
    }
  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
