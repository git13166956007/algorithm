package com.sherlock.leetcode;

import java.util.*;

/**
 * @author sherlock
 * @date 2022/10/19 14:34
 * @note
 **/
public class GetRow_119 {

    /**
     * 输入: rowIndex = 3
     * 输出: [1,3,3,1]
     *
     * 输入: rowIndex = 0
     * 输出: [1]
     *
     * 输入: rowIndex = 1
     * 输出: [1,1]
     *
     * 0 <= rowIndex <= 33
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        Deque<List<Integer>> result = new LinkedList<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        result.add(integers);
        if (rowIndex==1){
            List<Integer> list = result.pollFirst();
            list.add(1);
            return list;
        }
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> list = result.pollFirst();
            //多个
            int left = 0;
            int right = 1;
            List<Integer> integerList = new ArrayList<>();
            while (right<list.size()){
                integerList.add((list.get(left++)+list.get(right++)));
            }
            integerList.add(0,1);
            integerList.add(1);
            result.addLast(integerList);
        }
        return result.peekLast();
    }

    public static void main(String[] args) {
        GetRow_119 getRow_119 = new GetRow_119();
        List<Integer> row = getRow_119.getRow(1);
        System.out.println(row);
    }
}
