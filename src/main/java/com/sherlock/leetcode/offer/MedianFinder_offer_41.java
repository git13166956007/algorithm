package com.sherlock.leetcode.offer;

import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * @author Sherlock
 * @date 2022/2/14 14:02
 * @describe
 */
public class MedianFinder_offer_41 {

    PriorityQueue<Integer> max_Queue;
    PriorityQueue<Integer> min_Queue;
    public MedianFinder_offer_41() {
        min_Queue =new PriorityQueue<>();
        max_Queue =new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        if (max_Queue.size() != min_Queue.size()){
            min_Queue.add(num);
            max_Queue.add(min_Queue.poll());
        }else {
            max_Queue.add(num);
            min_Queue.add(max_Queue.poll());
        }
    }

    public double findMedian() {
        if (min_Queue.size()!= max_Queue.size()){
            return min_Queue.peek();
        }else {
            return (min_Queue.peek()+max_Queue.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder_offer_41 medianFinder_offer_41 = new MedianFinder_offer_41();
        medianFinder_offer_41.addNum(-1);
        System.out.println(medianFinder_offer_41.findMedian());
        medianFinder_offer_41.addNum(-2);
        System.out.println(medianFinder_offer_41.findMedian());
        medianFinder_offer_41.addNum(-3);
        System.out.println(medianFinder_offer_41.findMedian());
    }
}
