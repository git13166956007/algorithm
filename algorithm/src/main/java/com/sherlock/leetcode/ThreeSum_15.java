package com.sherlock.leetcode;

import java.util.*;

/**
 * @author Sherlock
 * @date 2022/1/7 15:04
 * @describe 15 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * eg:
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum_15 {

//    /**
//     * 暴力搜索解法
//     * @param nums 输入
//     * @return 输出
//     */
//    public List<List<Integer>> threeSum(int[] nums) {
//        Set<List<Integer>> result = new HashSet<>();
//        int size  = nums.length;
//        if (size>=3){
//            Arrays.sort(nums);
//            for (int i = 0;i <size-2 ;i++){
//                System.out.println(nums[i]);
//                for (int j = i+1 ;j <size-1 ;j++){
//                    System.out.println(nums[j]);
//                    for (int k = j+1 ;k <size ;k++){
//                        System.out.println("i="+nums[i]+" j="+nums[j]+" k="+nums[k]);
//                        if (nums[i]+nums[j]+nums[k]==0){
//                            List<Integer> list = new ArrayList<>();
//                            list.add(nums[i]);
//                            list.add(nums[j]);
//                            list.add(nums[k]);
//                            result.add(list);
//                        }
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(result);
//    }

    /**
     ***核心思路：如果直接三循环O(N^3)会报超时错误,所以要利用双指针将时间复杂度压到O(N^2)**
     * 1. 先对数组nums进行排序，升序
     * 2. 每次遍历到一个元素nums[i] = A
     * 3. 就利用双指针---头尾指针在（i，length）区间，找到nums[j] = B（头指针对应较小值）,nums[k] = C（尾指针对应较大值），B < C;就会出现三种情况
     * 4. A + B + C < 0：说明三个数合较小，则将B提高（j++），因为C已经是(j,k)中最大的了！
     * 5. A + B + C > 0：说明三个数合较大，则将C减小（k--），因为B已经是(j,k)中最小的了！
     * 6. A + B + C = 0: 说明恰好符合条件，直接添加入ans！因为要避免重复，所以需要将j++，k--到不同元素位置
     * @param nums 输入
     * @return 输出
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int size  = nums.length;
        if (size>=3){
            Arrays.sort(nums);
            //从小到大排序
            for (int k = 0; k < size-2; k++) {
               //如果当前是大于0
                if (nums[k]>0){
                    break;
                }
                if (k > 0 && nums[k]==nums[k-1]) {
                    continue;
                }
                //头部
                int i = k+1;
                //尾部
                int j = size-1;
                //还没有重合
                while (i<j){
                    int sum = nums[i]+nums[j]+nums[k];
                    if (sum==0){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        //将左右指针向中间靠拢
                        while (i<j && nums[i] == nums[++i]);
                        while (i<j && nums[j] == nums[--j]);
                    }
                    //小于0 需要左指针右移 增加sum
                    if (sum<0){
                        while (i<j && nums[i] == nums[++i]);
                    }
                    //大于0 需要将右指针左移 以减小sum
                    else if (sum>0){
                        while (i<j && nums[j] == nums[--j]);
                    }
                }
            }

        }
        return new ArrayList<>(result);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        long currentTimeMillis = System.currentTimeMillis();
        ThreeSum_15 threeSum15 = new ThreeSum_15();
        List<List<Integer>> lists = threeSum15.threeSum(nums);
        System.out.println("花费:"+(System.currentTimeMillis()-currentTimeMillis) +" 毫秒");
        System.out.println(lists);
    }
}
