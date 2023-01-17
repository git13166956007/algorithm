package com.sherlock.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sherlock
 * @date 2022/10/19 14:14
 * @note
 **/
public class Generate_118 {

    /**
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     *
     * 输入: numRows = 1
     * 输出: [[1]]
     *
     *
     * 1 <= numRows <= 30
     *
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = result.get(i - 1);
            if (list.size()==1){
                result.add(Arrays.asList(1,1));
            }else {
                //多个
                int left = 0;
                int right = 1;
                List<Integer> integerList = new ArrayList<>();
                while (right<list.size()){
                    integerList.add((list.get(left++)+list.get(right++)));
                }
                integerList.add(0,1);
                integerList.add(1);
                result.add(integerList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Generate_118 generate_118 = new Generate_118();
        List<List<Integer>> generate = generate_118.generate(5);
        System.out.println(generate);
    }
}
