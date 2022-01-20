package com.sherlock.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Sherlock on 2022/1/20 21:26
 *
 * @Version 1.0
 * @Note
 */
public class CQueue {

    private final Deque<Integer> firstStack;
    private final Deque<Integer> lastStack;
    public CQueue(){
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
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.deleteHead();cQueue.deleteHead();
        cQueue.deleteHead();
        int i = cQueue.deleteHead();
        System.out.println(i);
    }
}
