package com.sherlock.leetcode.offer;

/**
 * @author Sherlock
 * @date 2022/2/11 15:07
 * @describe
 */
public class MovingCount_offer_13 {
    /**
     * 1 <= n,m <= 100
     *
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] map = new boolean[m][n];
        return dfs(m,0,n,0,k,map);
    }

    private int dfs(int m,int i, int n,int j,int k, boolean[][] map){
        if (i<0 || i>=m || j<0 || j>=n || (i%10+i/10+j%10+j/10)>k || map[i][j]){
            return 0;
        }
        map[i][j] = true;
        return dfs(m,i+1,n,j,k,map)+dfs(m,i-1,n,j,k,map)+dfs(m,i,n,j+1,k,map)+dfs(m,i,n,j-1,k,map)+1 ;
    }


    public static void main(String[] args) {
        MovingCount_offer_13 movingCount_offer_13 = new MovingCount_offer_13();
        int i = movingCount_offer_13.movingCount(2, 3, 1);
        System.out.println(i);
    }


}
