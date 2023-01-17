package com.sherlock.leetcode;

/**
 * @author sherlock
 * @date 2022/12/16 16:59
 * @note
 **/
public class MinElements_1785 {

    /**
     * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
     *
     * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
     *
     * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
     *
     *
     * @param nums
     * @param limit
     * @param goal
     * @return 用int 存在长度溢出问题 需要注意用long类型
     */
    public int minElements(int[] nums, int limit, int goal) {
        for (int num : nums) {
            goal-=num;
        }
        long abs = Math.abs(goal);
        if (abs<limit){
            return 1;
        }
        if ((abs%limit)==0){
            return (int) abs/limit;
        }else {
            return (int)(abs/limit)+1;
        }
    }

    public static void main(String[] args) {
        MinElements_1785 minElements_1785 = new MinElements_1785();
        int i = minElements_1785.minElements(new int[]{-218143,-11211,209723,62333,107338,-176981,-131941,100553,149986,221450}, 229409, 311150635);
        System.out.println(i);
    }
}


