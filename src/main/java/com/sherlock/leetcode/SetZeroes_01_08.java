package com.sherlock.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sherlock
 * @date 2022/9/30 11:28
 * @node
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零
 *
 **/
public class SetZeroes_01_08 {

    /**
     *
     * 输入：
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * 输出：
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     *
     * 输入：
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出：
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/zero-matrix-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> zerosRow = new HashSet<>();
        Set<Integer> zerosCol = new HashSet<>();
        for (int i1 = 0; i1 < row; i1++) {
            for (int i = 0; i < col; i++) {
                if(matrix[i1][i] == 0){
                    zerosRow.add(i1);
                    zerosCol.add(i);
                }
            }
        }
        for (Integer integer : zerosRow) {
            int c = 0;
            while (c < col) {
                matrix[integer][c++] = 0;
            }
        }
        for (Integer integer : zerosCol) {
            int r = 0;
            while (r < row) {
                matrix[r++][integer] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ints = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        SetZeroes_01_08 setZeroes_01_08 = new SetZeroes_01_08();
        setZeroes_01_08.setZeroes(ints);
    }
}
