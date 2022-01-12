package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/10 16:22
 * @describe 相交链表
 */
public class GetIntersectionNode {
    /**
     *
     * @param headA 4,1,8,4,5
     * @param headB 5,6,1,8,4,5
     * @return 8
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null){
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        // nodeA = 4 1 8 4 5 5 6 1 8 4 5
        // nodeB = 5 6 1 8 4 5 4 1 8 4 5
        //因此相交的节点为 1
        while (nodeA!=nodeB){
            nodeA = nodeA == null?headB:nodeA.next;
            nodeB = nodeB == null?headA:nodeB.next;
        }
        return nodeA;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(8);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node6.next = node7;
        ListNode node8 = new ListNode(1);
        node7.next = node8;
        ListNode node9 = new ListNode(8);
        node8.next = node9;
        ListNode node10 = new ListNode(4);
        node9.next = node10;
        ListNode node11 = new ListNode(5);
        node10.next = node11;

        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode intersectionNode = getIntersectionNode.getIntersectionNode(node1, node6);
        System.out.println(intersectionNode.val);

    }

  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
