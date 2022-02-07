package com.sherlock.leetcode;

/**
 * Created by Sherlock on 2022/1/26 11:44
 *
 * @Version 1.0
 * @Note
 */
public class FloodFill_733 {


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        search(image,sr,sc,image[sr][sc],newColor);
        return image;
    }

    private void search(int[][] image, int sr, int sc,int current,int newColor){
        int row = image.length;
        int colum = image[0].length;
        if (sr<0||sr>=row || sc<0 ||sc>=colum || image[sr][sc]!=current || image[sr][sc]==newColor){
            return;
        }
        int curr = image[sr][sc];
        System.out.println("sr:"+sr +" sc:"+sc+" value:"+curr +"current:"+current);
        if (curr == current){
            image[sr][sc] = newColor;
            //向上
            search(image,sr-1,sc,current,newColor);
            //向下
            search(image,sr+1,sc,current,newColor);
            //向左
            search(image,sr,sc-1,current,newColor);
            //向右
            search(image,sr,sc+1,current,newColor);
        }

    }

    public static void main(String[] args) {
        int [][] image = new int[][]{
                {0,0,0},
                {0,1,1},
//                {1,0,1}
        };
        FloodFill_733 floodFill_733 = new FloodFill_733();
        floodFill_733.floodFill(image,1,1,1);
    }
}
