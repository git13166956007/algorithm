package com.sherlock.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sherlock on 2022/2/1 10:03
 *
 * @Version 1.0
 * @Note
 */
public class Combine_77 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return result;
    }


    private void backTracking(int n, int k, int startIndex){
        if (path.size() == k){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = startIndex; i <= n-(k+path.size())+1; i++) {
            path.add(i);
            backTracking(n,k,i+1);
            path.removeLast();
        }
    }
}
