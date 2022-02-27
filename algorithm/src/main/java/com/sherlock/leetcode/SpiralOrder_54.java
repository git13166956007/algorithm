package com.sherlock.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sherlock
 * @date 2022/1/17 18:16
 * @describe
 */
public class SpiralOrder_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        // int [][] 分别是Y 轴 和 X 轴
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int colum = matrix[0].length;
        //定义上下左右的边界
        int left = 0,right = colum-1,top = 0, bottom = row-1;
        while (left<=right && top <= bottom){
            //从左到右添加 上边界
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            //从上到下添加 右边界
            for (int i = top+1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            //判断当前是否还存在右边大于左边、下面大于上面的元素
            if (left<right && top < bottom){
                //从右边向左边添加 因为右边第一列已经被 由上至下的添加过了，所以需要从right-1开始，倒序写入  下边界
                for (int i = right-1; i > left; i --) {
                    list.add(matrix[bottom][i]);
                }
                //从下往上添加 左边界
                for (int i = bottom; i > top ; i--) {
                    list.add(matrix[i][left]);
                }
            }
            //将上下左右的边界缩小一圈
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }


    public static void main(String[] args) {
        int [][] matrix = new int[][]{
                {2,5},
                {8,4},
                {0,-1}
        };
        SpiralOrder_54 spiralOrder_54 = new SpiralOrder_54();
        List<Integer> list = spiralOrder_54.spiralOrder(matrix);
        list.forEach(System.out::println);
    }

}
