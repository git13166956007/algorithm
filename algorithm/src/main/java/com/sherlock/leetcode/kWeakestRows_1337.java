package com.sherlock.leetcode;

import java.util.*;

/**
 * @author Sherlock
 * @date 2022/8/9 0009 22:27
 * @describe
 **/
public class kWeakestRows_1337 {
    public int[] kWeakestRows(int[][] mat, int k) {

        int col = mat.length;
        int row = mat[0].length;
        Map<Integer, Integer> map = new HashMap<>(row);
        for (int i = 0; i < col; i++) {
            int index = 0;
            for (int j = 0; j < row; j++) {
                if(mat[i][j] == 1){
                    index++;
                }
            }
            map.put(i,index);
        }
        Map<Integer, Integer> map1 = sortMap(map);
        int index = 0;
        int[] result = new int[k];
        for (Map.Entry<Integer,Integer> ma: map1.entrySet()){
            if (index==k){
                break;
            }
            result[index++] =  ma.getKey();
        }
        return result;
    }
    public static Map<Integer, Integer> sortMap(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Comparator.comparingInt(Map.Entry::getValue));
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer,Integer> e : entryList) {
            linkedHashMap.put(e.getKey(),e.getValue());
        }
        return linkedHashMap;
    }


    public static void main(String[] args) {
//        [[1,0],[1,0],[1,0],[1,1]]
//        int[][] mat = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[][] mat = new int[][]{{1,0},{1,0},{1,0},{1,0},{1,1}};
        kWeakestRows_1337 k = new kWeakestRows_1337();
        int[] ints = k.kWeakestRows(mat, 4);
        System.out.println(ints);
    }
}
