package com.sherlock.leetcode.offer;

import java.util.List;

/**
 * @author Sherlock
 * @date 2022/2/8 14:04
 * @describe
 */
public class DeleteNode_offer_18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        if (head.val == val){
            return head.next;
        }
//        ListNode tempNode = head;
//        while (tempNode.next != null){
//            if (tempNode.next.val == val){
//                tempNode.next = tempNode.next.next;
//                break;
//            }
//            tempNode = tempNode.next;
//        }
//        return head;

        //双指针解法
        ListNode pre = head;
        ListNode current = head;
        while (current!=null){
            if (current.val == val){
                pre.next = current.next;
            }
            pre = current;
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(5);
        node1.next = node2;
        ListNode node3 = new ListNode(-99);
        node2.next = node3;
//        ListNode node4 = new ListNode(9);
//        node3.next = node4;
        DeleteNode_offer_18 deleteNode_offer_18 = new DeleteNode_offer_18();
        deleteNode_offer_18.deleteNode(node1,-99);
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
