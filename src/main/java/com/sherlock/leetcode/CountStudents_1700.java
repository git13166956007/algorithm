package com.sherlock.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sherlock
 * @date 2022/10/19 9:41
 * @note
 **/
public class CountStudents_1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> deque = new LinkedList<>();
        for (int student : students) {
            deque.add(student);
        }
        int sand = 0;
        int result = 0;
        while (!deque.isEmpty()){
            Integer pollFirst = deque.pollFirst();
            if (pollFirst!=sandwiches[sand]){
                deque.addLast(pollFirst);
                result++;
            }else {
                sand++;
                result=0;
            }
            if (result == deque.size()){
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /**
         * [0,0,1,1,0,0,0,0,1,0,0,1,1,0,1,1]
         * [1,0,0,0,0,0,0,1,0,0,1,0,1,1,1,0]
         */
        CountStudents_1700 countStudents_1700 = new CountStudents_1700();
        int i = countStudents_1700.countStudents(new int[]{0,0,1,1,0,0,0,0,1,0,0,1,1,0,1,1}, new int[]{1,0,0,0,0,0,0,1,0,0,1,0,1,1,1,0});
        System.out.println(i);
    }
}
