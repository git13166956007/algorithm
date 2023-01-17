package com.sherlock.leetcode;

/**
 * Created by Sherlock on 2022/1/29 15:08
 *
 * @Version 1.0
 * @Note
 */
public class OrangesRotting_994 {

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int colum = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                //挑出当前第一次感染的
                if (grid[i][j] == 2){
                    search(grid,i,j,2);
                }
            }
        }
        int time = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                time = Math.max(grid[i][j]-2,time);
            }
        }
        return time;
    }

    private void search(int[][] grid,int row,int colum ,int level){
        if (row < 0 || row>= grid.length || colum < 0 || colum >= grid[0].length ){
            return;
        }
        if (grid[row][colum]!=1 && grid[row][colum] < level){
            return;
        }
        //感染
        grid[row][colum] = level;

        level ++;
        //向上
        search(grid,row-1,colum,level);
        //向下
        search(grid,row+1,colum,level);
        //向左
        search(grid,row,colum - 1,level);
        //向右
        search(grid,row,colum + 1,level);
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1},
        };
        OrangesRotting_994 orangesRotting_994 = new OrangesRotting_994();
        int i = orangesRotting_994.orangesRotting(grid);
        System.out.println(i);

    }

}
