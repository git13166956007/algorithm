package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/9/30 13:47
 * @node
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class MaxArea_11 {


    /**
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     *
     * 输入：height = [1,1]
     * 输出：1
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int length = height.length;
        if (length==2){
            return Math.min(height[0],height[1]);
        }
        int maxArea = 0;
        int left = 0;
        int right = length-1;
        while (left<right){
            if (height[left] < height[right]){
                maxArea = Math.max(maxArea, (right - left) * height[left++]);
            }else {
                maxArea = Math.max(maxArea, (right - left) * height[right--]);
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        MaxArea_11 maxArea_11 = new MaxArea_11();
        int i = maxArea_11.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(i);
    }
}
