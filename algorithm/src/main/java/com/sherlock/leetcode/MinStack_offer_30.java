package com.sherlock.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Sherlock on 2022/1/20 22:09
 *
 * @Version 1.0
 * @Note
 */
public class MinStack_offer_30 {

    private final LinkedList<Integer> list;
    private final LinkedList<Integer> minList;

    public MinStack_offer_30() {
        list = new LinkedList<>();
        minList = new LinkedList<>();
    }

    public void push(int x) {
        if(minList.isEmpty()){
            minList.push(x);
        }else {
            minList.push(Math.min(x,minList.peek()));
        }
        list.push(x);
    }

    public void pop() {
        list.pop();
        minList.pop();
    }

    public int top() {
        if (!list.isEmpty()){
            return list.peek();
        }
        return -1;
    }

    public int min() {
        if (!minList.isEmpty()){
            return minList.peek();
        }
        return -1;
    }
}
