package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/1/21 17:59
 * @describe
 */
public class CopyRandomList_offer_35 {
    public Node copyRandomList(Node head) {
        Node node = head;
        Node result = new Node(0);
        Node node1 = result;
        while (node!=null){
            node1.val = node.val;
            node1.next = node.next;
            node = node.next;
        }
        return result;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
