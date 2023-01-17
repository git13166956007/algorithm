package com.sherlock.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Sherlock
 * @date 2022/2/14 10:38
 * @describe
 */
public class IsStraight_offer_61 {

    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 输入: [0,0,1,2,5]
     * 输出: True
     *
     * 这是因为 0可以是看作任何数字
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int index_0 = 0;
        int index_other = 0;
        if (nums[0]==0){
            index_0++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0){
                index_0++;
            }
            if (nums[i-1]!=0 && nums[i]-nums[i-1] == 0){
                return false;
            }
            if (nums[i-1]!=0 && (nums[i]!= nums[i-1])&& nums[i]-nums[i-1] != 1){
                index_other += nums[i]-nums[i-1]-1;
            }
        }
        return index_0 >= index_other;
    }


    public static void main(String[] args) {
        IsStraight_offer_61 isStraight_offer_61 = new IsStraight_offer_61();
        isStraight_offer_61.isStraight(new int[]{0,0,2,2,5});
    }
}
