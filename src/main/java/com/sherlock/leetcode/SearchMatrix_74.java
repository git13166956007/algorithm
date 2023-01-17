package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/8/11 9:59
 * @node  搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/
public class SearchMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length;
        int row = matrix.length;
        if (col==1 && row==1&&target==matrix[0][0]){
            return true;
        }else if (col==1 && row==1&&target!=matrix[0][0]){
            return false;
        }
        int top = 0;
        int bottom = row-1;
        while (top<= bottom){
            int center = top + (bottom - top)/2;
            if (target==matrix[center][0]){
                //目标值在上一行
                int left = 0;
                int right = col-1;
                while (left<=right){
                    int mid = left + (right - left)/2;
                    if (target == matrix[center][mid]){
                        return true;
                    } else if (target<matrix[center][mid]){
                        right = mid -1;
                    }if (target> matrix[center][mid]){
                        left = mid +1;
                    }
                }
            }else if (target>= matrix[center][0]){
                top = center + 1;
            }else {
                bottom = center - 1;
            }
        }
        --top;
        if (top<0){
            top = 0;
        }
        //目标值在上一行
        int left = 0;
        int right = col-1;
        while (left<=right){
            int mid = left + (right - left)/2;
            if (target == matrix[top][mid]){
                return true;
            } else if (target<matrix[top][mid]){
                right = mid -1;
            }else if (target> matrix[top][mid]){
                left = mid +1;
            }
        }
        return false;
    }

    /**
     * 获取数组元素插入位置
     * @param target 目标值
     * @param nums 数组
     * @return 插入位置
     */
    public int getMin(Integer target,int[] nums){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + (right - left)/2;
            if (target == nums[mid]){
               return mid;
            }else if (target>= nums[mid]){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //[[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        //matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = new int[][]{{1},{1}};
        int target = 0;
        SearchMatrix_74 searchMatrix_74 = new SearchMatrix_74();
        boolean b = searchMatrix_74.searchMatrix(matrix, target);
        System.out.println(b);
//        int[] nums = new int[]{2,3,5,10};
//        int target = 4;
//        int min = searchMatrix_74.getMin(target, nums);
//        System.out.println(min);
    }
}
