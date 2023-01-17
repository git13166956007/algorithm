package com.sherlock.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Sherlock on 2022/1/20 21:26
 *
 * @Version 1.0
 * @Note
 */
public class CQueue_offer_09 {

    private final Deque<Integer> firstStack;
    private final Deque<Integer> lastStack;
    public CQueue_offer_09(){
        firstStack = new LinkedList<>();
        lastStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        firstStack.add(value);
    }

    public int deleteHead() {
        if (lastStack.isEmpty()){
            while (!firstStack.isEmpty()){
                lastStack.add(firstStack.pop());
            }
        }
        if (lastStack.isEmpty()){
            return -1;
        }
        return lastStack.pop();
    }


    public static void main(String[] args) {
        CQueue_offer_09 cQueueOffer09 = new CQueue_offer_09();
        cQueueOffer09.appendTail(1);
        cQueueOffer09.appendTail(2);
        cQueueOffer09.appendTail(3);
        cQueueOffer09.deleteHead();
        cQueueOffer09.deleteHead();
        cQueueOffer09.deleteHead();
        int i = cQueueOffer09.deleteHead();
        System.out.println(i);
    }
}
