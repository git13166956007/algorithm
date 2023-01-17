package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/14 15:32
 * @describe 200 岛屿数量200
 */
public class NumIslands_200 {
    /**
     * grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int numIslands = 0;
        for (int i = 0 ; i < row; i++){
            for (int j = 0 ; j < column; j++){
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid,int r,int c){
        //判断是否在区域内 因为在找上下左右陆地时可能存在数组越界现象，所以提前得判断是否还在范围内
        // 并且过滤值为2的陆地，不然会导致栈溢出
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1'){
            return;
        }
        //把当前陆地更改 ，表示已经遍历过了，避免重复遍历
        grid[r][c] = '2';
        //遍历岛屿 当前陆地的上下左右
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        NumIslands_200 numIslands_200 = new NumIslands_200();
        int i = numIslands_200.numIslands(grid);
        System.out.println(i);
    }
}
