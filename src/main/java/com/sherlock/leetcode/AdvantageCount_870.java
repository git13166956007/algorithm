package com.sherlock.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sherlock
 * @date 2022/10/8 9:33
 * @node
 *
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 *
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/advantage-shuffle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 **/
public class AdvantageCount_870 {

    /**
     * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
     * 输出：[2,11,7,15]
     *
     *
     * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
     * 输出：[24,32,8,12]
     *
     * 思路： 对nums1进行排序，然后对nums2循环遍历在nums1中二分寻找大于当前值的最小值。如果没有，则用原位置的元素
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
//        List<Integer> collect = Arrays.stream(nums1).sorted().boxed().collect(Collectors.toList());
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums2.length; i++) {
//            int i1 = binarySearch(collect, nums2[i]);
//            if (i1<collect.size()){
//                list.add(collect.get(i1));
//                collect.remove(i1);
//            }else if (i1>=nums1.length) {
//                list.add(collect.get(collect.size() - 1));
//                collect.remove(collect.size() - 1);
//            }else {
//                list.add(nums1[i1]);
//                collect.remove(Integer.valueOf(nums1[i1]));
//            }
//        }
//        return list.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(nums1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for(int i=0;i<nums2.length;i++) {
            queue.offer(new int[]{i,nums2[i]});
        }
        int left = 0;
        int right = nums1.length - 1;
        int[] result = new int[nums2.length];
        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int index = pair[0];
            int num = pair[1];
            if(nums1[right] > num) {
                result[index] = nums1[right];
                right--;
            }else {
                result[index] = nums1[left];
                left++;
            }
        }
        return result;
    }

    private int binarySearch(List<Integer> nums,int target){
        int length = nums.size();
        int left = 0;
        int right = length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums.get(mid) == target){
                return left + 1;
            }else if (nums.get(mid)< target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        /**
         * [2,0,4,1,2]
         * [1,3,0,0,2]
         *
         *
         * [2,0,2,1,4]
         *
         *
         * [718967141,189971378,341560426,23521218,339517772]
         * [967482459,978798455,744530040,3454610,940238504]
         *
         */
        AdvantageCount_870 advantageCount_870 = new AdvantageCount_870();
        int[] ints = advantageCount_870.advantageCount(new int[]{718967141,189971378,341560426,23521218,339517772}, new int[]{967482459,978798455,744530040,3454610,940238504});
        System.out.println(ints);
    }
}
