package com.sherlock.leetcode;

import java.util.Arrays;

/**
 * @author sherlock
 * @date 2022/10/13 9:57
 * @node
 *
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 *
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 *
 * 返回数组能分成的最多块数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-chunks-to-make-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 **/
public class MaxChunksToSorted_769 {

    /**
     * 输入: arr = [4,3,2,1,0]
     * 输出: 1
     * 解释:
     * 将数组分成2块或者更多块，都无法得到所需的结果。
     * 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/max-chunks-to-make-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     *
     *
     * 输入: arr = [1,0,2,3,4]
     * 输出: 4
     * 解释:
     * 我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
     * 然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/max-chunks-to-make-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int length = arr.length;
        int currMax = 0;
        int count = 0;
        int[] clone = arr.clone();
        Arrays.sort(clone);
        //当前区域的最大值一定等于当前坐标,这时候为1个区间
        for (int i = 0; i < length; i++) {
            currMax = Math.max(currMax,arr[i]);
            if (currMax == clone[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxChunksToSorted_769 maxChunksToSorted_769 = new MaxChunksToSorted_769();
        int i = maxChunksToSorted_769.maxChunksToSorted(new int[]{3,1,6,2,0,8});
        System.out.println(i);
    }
}
