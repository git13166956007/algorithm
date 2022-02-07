package com.sherlock.leetcode.offer;

/**
 * Created by Sherlock on 2022/1/26 15:04
 *
 * @Version 1.0
 * @Note
 */
public class FindNumberIn2DArray_offer_04 {

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        int colum = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = colum-1;
            while (left<=right){
                int mid = left + (right-left)/2;
                if (matrix[i][mid]== target){
                    return true;
                }else if (matrix[i][mid]>target){
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
