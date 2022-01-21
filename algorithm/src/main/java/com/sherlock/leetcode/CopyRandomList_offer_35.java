package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/21 17:59
 * @describe
 */
public class CopyRandomList_offer_35 {
    public Node copyRandomList(Node head) {

        return null;
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
