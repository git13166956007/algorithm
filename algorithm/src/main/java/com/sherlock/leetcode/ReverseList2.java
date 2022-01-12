package com.sherlock.leetcode;

import java.util.List;

/**
 * @author Sherlock
 * @date 2021/12/28 9:39
 * @describe
 */
public class ReverseList2 {

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
//        ListNode node = ReverseList2.iteratorReverseList(node1);
        ListNode listNode = reverseBetween(node1, 2, 4);
        System.out.println(listNode);

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

    /**
     * 反转链表II 1->2->3->4->5  1->4->3->2->5
     * @param head 原始链表
     * @param left 左边位置
     * @param right 右边位置
     * @return 返回反转后的链表
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftLinked = new ListNode();
        ListNode targetLinked = new ListNode() ;
        ListNode rightLinked = new ListNode();
        ListNode currentNode = new ListNode();
        currentNode = head;
        int position = 1;
        while (currentNode!=null){
            if (position<left){
                leftLinked.next = currentNode;
                currentNode = currentNode.next;
                leftLinked.next.next = null;
            }
            if (left <= position && position <= right){
                targetLinked.next = currentNode;
                currentNode = currentNode.next;
                targetLinked.next.next = null;
            }
            if (position > right){
                rightLinked.next = currentNode;
                currentNode = currentNode.next;
                rightLinked.next.next = null;
            }

            position++;
        }

        System.out.println(11111);


        return null;
    }

    /**
     * 截取指定位置之间的链表
     * @param head 链表
     * @param left 开始位置
     * @param right 结束位置
     * @return 返回截取后的子链表
     */
    public static ListNode subLinked(ListNode head,int left, int right){
        ListNode currentNode = head;
        ListNode targetLinked = new ListNode();
        int index = 1;
        while (currentNode!=null){
            if(left<= index&& index <= right){
                targetLinked.next = currentNode;
            }
            currentNode = currentNode.next;
            index ++;
        }


        //拼接 before最后一个的next 拼接 target , target最后一个拼接 after

        return null;
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
