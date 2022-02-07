package com.sherlock.leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Sherlock on 2022/1/26 23:41
 *
 * @Version 1.0
 * @Note
 */
public class FirstUniqChar_offer_50 {

    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        if (chars.length==0){
            return ' ';
        }
        for (char aChar : chars) {
            if (map.containsKey(aChar)){
                map.put(aChar,false);
            }else {
                map.put(aChar,true);
            }
        }
        for (Map.Entry<Character,Boolean> mp: map.entrySet()){
            if (mp.getValue()){
                return mp.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "leetcode";
        FirstUniqChar_offer_50 firstUniqChar_offer_50 = new FirstUniqChar_offer_50();
        char c = firstUniqChar_offer_50.firstUniqChar(s);
        System.out.println(c);

    }
}
