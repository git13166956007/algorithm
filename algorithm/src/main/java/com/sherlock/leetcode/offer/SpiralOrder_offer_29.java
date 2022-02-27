package com.sherlock.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sherlock
 * @date 2022/2/15 10:52
 * @describe
 */
public class SpiralOrder_offer_29 {


    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     *
     *  顺时针打印矩阵
     *
     *
     *  输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *
     *
     * @param matrix
     * @return
     *
     * 深度遍历 遍历顺序  右 -》 下 ——》 左 ——》 上 ——》右
     *
     * 此题不能用染色法
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = columns-1;
        int[] res = new int[rows*columns];
        int index = 0;
        while (left <= right && top <= bottom){
            //收集从左到右
            for (int i = left;i<=right;i++){
                res[index++]=matrix[top][i];
            }

            //从上到下
            for (int i = top+1; i <= bottom ; i++) {
                res[index++]=matrix[i][right];
            }

            if (top<bottom && left < right){
                //从右到左
                for (int i = right-1; i > left ; i--) {
                    res[index++]=matrix[bottom][i];
                }
                //从下到上
                for (int i = bottom; i > top ; i--) {
                    res[index++]=matrix[i][left];
                }
            }
            bottom--;
            right--;
            left++;
            top++;
        }
        return res;
    }


    public static void main(String[] args) {
        SpiralOrder_offer_29 spiralOrder_offer_29 = new SpiralOrder_offer_29();
        int[] ints = spiralOrder_offer_29.spiralOrder(new int[][]{
                {2,5},
                {8,4},
                {0,-1},
        });
        System.out.println(ints);
    }
}
