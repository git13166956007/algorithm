package com.sherlock.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sherlock
 * @date 2022/2/11 18:24
 * @describe
 */
public class MajorityElement_offer_39 {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],(map.get(nums[i])+1));
            }else {
                map.put(nums[i],1);
            }
        }
        int count = length/2;
        for (Map.Entry<Integer,Integer> mas: map.entrySet()){
            if (mas.getValue()>count){
                return mas.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MajorityElement_offer_39 majorityElement_offer_39 = new MajorityElement_offer_39();
        majorityElement_offer_39.majorityElement(new int[]{3,2,3});
    }
}
