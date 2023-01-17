package com.sherlock.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sherlock on 2022/1/27 19:37
 *
 * @Version 1.0
 * @Note
 */
public class ContainsDuplicate_217 {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])){
                Integer integer = map.get(nums[i]);
                map.put(nums[i],++integer);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> mp : map.entrySet()){
            if (mp.getValue()>1){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4};
        ContainsDuplicate_217 containsDuplicate_217 = new ContainsDuplicate_217();
        boolean b = containsDuplicate_217.containsDuplicate(nums);
        System.out.println(b);
    }
}
