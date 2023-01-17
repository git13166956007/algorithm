package com.sherlock.leetcode;

import com.sherlock.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sherlock
 * @date 2022/10/12 15:40
 * @node
 *
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-components
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 **/
public class NumComponents_817 {


    /**
     * 输入: head = [0,1,2,3], nums = [0,1,3]
     * 输出: 2
     * 解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/linked-list-components
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     *
     * 输入: head = [0,1,2,3,4], nums = [0,3,1,4]
     * 输出: 2
     * 解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/linked-list-components
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * @param head
     * @param nums
     * @return
     */
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode p = head;
        int count = 0;
        while (p!=null){
            if (collect.contains(p.val)&&(p.next == null || !collect.contains(p.next.val))){
                count++;
            }
            p = p.next;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,3};
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        ListNode listNode0 = new ListNode(0,listNode1);
        NumComponents_817 numComponents_817 = new NumComponents_817();
        int i = numComponents_817.numComponents(listNode0, nums);
        System.out.println(i);
    }
}
