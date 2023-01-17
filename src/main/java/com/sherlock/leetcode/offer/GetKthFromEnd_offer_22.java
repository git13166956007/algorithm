package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/2/8 15:33
 * @describe
 */
public class GetKthFromEnd_offer_22 {
    /**
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     *
     * 利用快慢指针 快指针比慢指针多k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tempNode = head;
        ListNode fastNode = head;
        ListNode slowNode = head;
        int index = 0;
        boolean flag = false;
        while (fastNode != null && tempNode != null){
            fastNode = tempNode;
            if (index == k){
                flag = true;
            }
            if (flag){
                slowNode = slowNode.next;
            }
            index++;
            tempNode = tempNode.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        GetKthFromEnd_offer_22 getKthFromEnd_offer_22 = new GetKthFromEnd_offer_22();
        getKthFromEnd_offer_22.getKthFromEnd(node1,2);
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
