package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/8/8 0008 21:48
 * @describe
 *
 *
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MySqrt_69 {
    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根,
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去
     *
     * 本题可用牛顿迭代法来解决
     * （x+target/x）/target
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        int left = 0;
        int right = x/2;
        while (left<=right){
            int mid = left + (right - left)/2;
            //乘法换除法，防止溢出
            if ((mid!=0 &&(mid > x/mid))||mid*mid>x){
                right = mid-1;
            }else if ((mid!=0 &&(mid < x/mid))||mid*mid<x){
                left = mid +1;
            }else {
                return mid;
            }
        }
        return right;
    }

    int s ;
    public int mySqrt1(int x){
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }


    public static void main(String[] args) {
        MySqrt_69 m = new MySqrt_69();
        System.out.println(m.mySqrt(2));

    }

}
