package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/2/9 18:17
 * @describe
 */
public class GetIntersectionNode_offer_52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA ==null ){
            return null;
        }
        if (headB ==null ){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA!=tempB){
            tempA = tempA ==null?headB:tempA.next;
            tempB = tempB ==null?headA:tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(9);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(1);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(2);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(4);
        listNode4.next = listNode5;

        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(2);
        listNode6.next = listNode7;
        ListNode listNode8 = new ListNode(4);
        listNode7.next = listNode8;


        GetIntersectionNode_offer_52 getIntersectionNode_offer_52 = new GetIntersectionNode_offer_52();
        getIntersectionNode_offer_52.getIntersectionNode(listNode1,listNode6);
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode (int x){
            val = x;
        }
    }
}
