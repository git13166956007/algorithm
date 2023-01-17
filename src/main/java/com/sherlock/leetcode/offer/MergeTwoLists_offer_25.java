package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/2/8 16:02
 * @describe
 */
public class MergeTwoLists_offer_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1、如果l1 大于 l2 ，就以l2 作为主链，否则就以 l1作为主链
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        if (l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(4);
        listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(4);
        listNode5.next = listNode6;

        MergeTwoLists_offer_25 mergeTwoLists_offer_25 = new MergeTwoLists_offer_25();
        ListNode listNode = mergeTwoLists_offer_25.mergeTwoLists(listNode1, listNode4);
        System.out.println(listNode);

    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
