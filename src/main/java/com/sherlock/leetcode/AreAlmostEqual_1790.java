package com.sherlock.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sherlock
 * @date 2022/10/11 9:39
 * @node
 *
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 *
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class AreAlmostEqual_1790 {


    /**
     * 输入：s1 = "bank", s2 = "kanb"
     * 输出：true
     * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
     *
     * 输入：s1 = "attack", s2 = "defend"
     * 输出：false
     * 解释：一次字符串交换无法使两个字符串相等
     *
     * 输入：s1 = "kelb", s2 = "kelb"
     * 输出：true
     * 解释：两个字符串已经相等，所以不需要进行字符串交换
     *
     *
     * 输入：s1 = "abcd", s2 = "dcba"
     * 输出：false
     *
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
//        char[] chars1 = s1.toCharArray();
//        char[] chars2 = s2.toCharArray();
//        int flag = 0;
//        for (int i = 0; i < chars1.length; i++) {
//            if(chars1[i]!= chars2[i]){
//                if (!s2.contains(""+chars1[i])){
//                    return false;
//                }
//                boolean fl = false;
//                //找到正确字符与当前字符位置调换
//                for (int j = i; j < s2.length(); j++) {
//                    if (!s1.contains(""+chars2[j])){
//                        return false;
//                    }
//                    if (chars2[j]==chars1[i]&&chars1[j]!=chars2[j]){
//                        chars2[i]^=chars2[j];
//                        chars2[j]^=chars2[i];
//                        chars2[i]^=chars2[j];
//                        flag++;
//                        fl = true;
//                        break;
//                    }
//                }
//                if (!fl){
//                    return false;
//                }
//            }
//        }
//        return flag <= 1;

        List<Integer> swap = new ArrayList<>();
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i)!=s2.charAt(i)){
                if (swap.size()>1){
                    return false;
                }
                swap.add(i);
            }
        }
        if (swap.isEmpty()){
            return true;
        }
        if (swap.size()==1){
            return false;
        }
        return s1.charAt(swap.get(0))==s2.charAt(swap.get(1)) && s1.charAt(swap.get(1))==s2.charAt(swap.get(0));

    }


//    "kzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhqkxumonfgrczmjvbhwvhpnocz"
//    "qzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhkkxumonfgrczmjvbhwvhpnocz"
    public static void main(String[] args) {


        AreAlmostEqual_1790 areAlmostEqual_1790 = new AreAlmostEqual_1790();
        boolean b = areAlmostEqual_1790.areAlmostEqual("yhy", "hyc");
        System.out.println(b);
    }
}
