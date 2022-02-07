package com.sherlock.leetcode;

/**
 * Created by Sherlock on 2022/1/26 13:07
 *
 * @Version 1.0
 * @Note
 */
public class MaxAreaOfIsland_695 {

    private int index =0;
    /**
     * 计算出最大岛屿
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int colum = grid[0].length ;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                index = 0;
                if (grid[i][j]==1){
                    search(grid, i, j);
                    max = Math.max(max,index);
                }
            }
        }
        return max;
    }

    private void search(int[][] gird, int row, int colum){
        if (row<0|| row>= gird.length || colum<0|| colum>=gird[0].length || gird[row][colum]!=1){
            return;
        }
        index ++;
        //染色
        int current = gird[row][colum];
        gird[row][colum] = 2;
        //如果等于1，就进行上线左右遍历
        if (current == 1){
            //向上
            search(gird,row-1,colum);
            //向右
            search(gird,row,colum+1);
            //向下
            search(gird,row+1,colum);
            //向左
            search(gird,row,colum-1);
        }
    }

    public static void main(String[] args) {
        int [][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0},
        };
        MaxAreaOfIsland_695 maxAreaOfIsland_695 = new MaxAreaOfIsland_695();
        int i = maxAreaOfIsland_695.maxAreaOfIsland(grid);
        System.out.println(i);
    }
}
