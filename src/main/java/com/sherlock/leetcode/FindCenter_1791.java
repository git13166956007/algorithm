package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/12/16 17:45
 * @note
 **/
public class FindCenter_1791 {

    public int findCenter(int[][] edges) {
//        Map<Integer,Integer> map = new HashMap<>();
//        int center = 0;
//        int max = 0;
//        for (int[] edge : edges) {
//            int x = edge[0];
//            int y = edge[1];
//            if (map.containsKey(x)){
//                int integer = map.get(x);
//                if (max<=integer){
//                    max = integer;
//                    center = x;
//                }
//                integer++;
//                map.put(x,integer);
//            }else {
//                map.put(x,1);
//            }
//
//            if (map.containsKey(y)){
//                int integer = map.get(y);
//                if (max<=integer){
//                    max = integer;
//                    center = y;
//                }
//                integer++;
//                map.put(y,integer);
//            }else {
//                map.put(y,1);
//            }
//        }
//        return center;
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public static void main(String[] args) {
        FindCenter_1791 findCenter_1791 = new FindCenter_1791();
        int center = findCenter_1791.findCenter(new int[][]{{1, 2}, {2,3}, {4,2}});
        System.out.println(center);
    }
}
