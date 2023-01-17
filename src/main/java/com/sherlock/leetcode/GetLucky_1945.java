package com.sherlock.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sherlock
 * @date 2022/12/15 13:31
 * @note
 *
 * 给你一个由小写字母组成的字符串 s ，以及一个整数 k 。
 *
 * 首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。
 *
 * 例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：
 *
 * 转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 * 转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 * 转换 #2：17 ➝ 1 + 7 ➝ 8
 * 返回执行上述操作后得到的结果整数。
 *
 *
 **/
public class GetLucky_1945 {

    static Map<String,String> map = new HashMap<>(26);
    static {
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        map.put("d","4");
        map.put("e","5");
        map.put("f","6");
        map.put("g","7");
        map.put("h","8");
        map.put("i","9");
        map.put("j","10");
        map.put("k","11");
        map.put("l","12");
        map.put("m","13");
        map.put("n","14");
        map.put("o","15");
        map.put("p","16");
        map.put("q","17");
        map.put("r","18");
        map.put("s","19");
        map.put("t","20");
        map.put("u","21");
        map.put("v","22");
        map.put("w","23");
        map.put("x","24");
        map.put("y","25");
        map.put("z","26");
    }
    /**
     * 给你一个由小写字母组成的字符串 s ，以及一个整数 k 。
     * @param s 字符串
     * @param k 一个整数
     * @return
     */
    public int getLucky(String s, int k) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            sb.append(map.get(c + ""));
        }
        for (int i = 0; i < k; i++) {
            String s1 = sb.toString();
            char[] chars = s1.toCharArray();
            int sum = 0;
            for (char aChar : chars) {
                int aa = aChar-'0';
                sum +=aa;
            }
            sb.setLength(0);
            sb.append(sum);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        GetLucky_1945 getLucky_1945 = new GetLucky_1945();
        int iiii = getLucky_1945.getLucky("leetcode", 2);
        System.out.println(iiii);
    }
}
