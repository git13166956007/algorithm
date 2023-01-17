package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2021/12/27 17:10
 * @describe
 */
public class ReverseList_206 {

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
//        ListNode node = reverseList.reverseList(node1);
        ListNode node = ReverseList_206.iteratorReverseList(node1);
        System.out.println(node);

    }

    /**
     * 利用 递归
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        if (head ==null || head.next ==null){
            return head;
        }
        ListNode nextNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        System.out.println(head.val);
        return nextNode;
    }

    /**
     * 利用 迭代
     * @param head
     * @return
     */
    public static ListNode iteratorReverseList(ListNode head){
        ListNode preNode = null;
        ListNode currentNode = head;
        while (currentNode !=null){
            //下一个节点
            ListNode nextNode = currentNode.next;
            //当前节点的下一个节点赋值为前一个节点
            currentNode.next = preNode;
            //以下步为下次循环做的准备
            //将前一个节点更新为当前节点
            preNode = currentNode;
            //将当前节点赋值为下一个节点
            currentNode = nextNode;
        }
        return preNode;
    }

    private static class ListNode{
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) {
             this.val = val;
             this.next = next;
         }
    }
}
