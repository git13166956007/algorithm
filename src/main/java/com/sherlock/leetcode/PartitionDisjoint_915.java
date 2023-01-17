package com.sherlock.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sherlock
 * @date 2022/10/24 10:17
 * @note
 *
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 *
 * 用例可以保证存在这样的划分方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-array-into-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class PartitionDisjoint_915 {

    /**
     *输入：nums = [5,0,3,8,6]
     * 输出：3
     * 解释：left = [5,0,3]，right = [8,6]
     *
     *
     * 输入：nums = [1,1,1,0,6,12]
     * 输出：4
     * 解释：left = [1,1,1,0]，right = [6,12]
     *
     *
     * @param nums
     * @return
     */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0];
        int left = 0;
        int currentMax = nums[0];
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(currentMax,nums[i]);
            if (nums[i]<leftMax){
                leftMax = currentMax;
                left = i;
            }
        }
        return left+1;
    }

    public static void main(String[] args) {
        PartitionDisjoint_915 partitionDisjoint_915 = new PartitionDisjoint_915();
//        int i = partitionDisjoint_915.partitionDisjoint(new int[]{5,0,3,8,6});
//        System.out.println(i);

        String a1 = "22";
        String a2 = "1-201";
        String a3 = "1-3562";

        String portString = "4,22,1,8,30,23-36,50-300,2-17,20-44,0-65535";
        List<String> list = partitionDisjoint_915.mergerPort(portString);
        System.out.println(list);
    }

    /**
     * 端口合并及拆分
     * @param portString 端口列表
     * @return 返回拆分之后的端口
     */
    public List<String> mergerPort(String portString){
        //去重之后的数据
        List<String> ports = Arrays.stream(portString.split(",")).distinct().collect(Collectors.toList());
        //1、拆分端口和端口段
        List<String> priorityQueue = new ArrayList<>();
        PriorityQueue<String> segmentPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> Integer.parseInt(o.split("-")[0])));
        for (String s : ports) {
            //端口段
            if (s.contains("-")){
                segmentPriorityQueue.add(s);
            }else {
                priorityQueue.add(s);
            }
        }
        int[][] segmentArrayPort = new int[segmentPriorityQueue.size()][2];
        int i = 0;
        while (!segmentPriorityQueue.isEmpty()){
            String poll = segmentPriorityQueue.poll();
            segmentArrayPort[i][0] = Integer.parseInt(poll.split("-")[0]);
            segmentArrayPort[i][1] = Integer.parseInt(poll.split("-")[1]);
            i++;
        }
        //2、合并端口段
        int[][] merge = this.merge(segmentArrayPort);
        //3、去除已覆盖的端口
        PriorityQueue<String> queue = this.removePort(priorityQueue, merge);
        //未覆盖端口
        //4、端口区间转换端口段根据阈值拆分
        List<String> segmentAfterSplit = this.intervalConvertSegment(merge);
        //轮询分配策略
        Map<String,String> map = new HashMap<>();
        if (segmentAfterSplit.size()>queue.size()){
            for (String s : segmentAfterSplit) {
                if (!queue.isEmpty()){
                    String poll = queue.poll();
                    map.merge(s, poll, (a, b) -> a + "," + b);
                }else {
                    map.put(s,"");
                }
            }
        }else {
            while (!queue.isEmpty()){
                for (String s : segmentAfterSplit) {
                    String poll = queue.poll();
                    if (poll!=null){
                        map.merge(s, poll, (a, b) -> a + "," + b);
                    }
                }
            }
        }
        List<String> result = new ArrayList<>();
        map.forEach((k, v)->{
            result.add(Objects.equals(v, "") ?k:k+","+v);
        });
        return result;
    }

    /**
     * 区间转换段并且拆分
     * @param mergeSegmentPort 区间
     * @return 拆分之后的拆分段
     */
    private List<String> intervalConvertSegment(int[][] mergeSegmentPort){
        List<String> segmentList = new ArrayList<>();
        for (int[] ints : mergeSegmentPort) {
            segmentList.addAll(this.segmentPort(ints[0] + "-" + ints[1]));
        }
        return segmentList;
    }


    /**
     * 移除重复端口
     * @param ports 单端口列表
     * @param intervalsPort 端口区间
     * @return 无覆盖端口列表
     */
    private PriorityQueue<String> removePort(List<String> ports,int[][] intervalsPort){
        List<String> result = new ArrayList<>(ports);
        for (String s : ports) {
            int port = Integer.parseInt(s);
            int length = intervalsPort.length;
            int index = 0;
            while (index < length) {
                //在当前区间内
                if (intervalsPort[index][0] < port && intervalsPort[index][1] > port) {
                    result.remove(s);
                    break;
                }
                index++;
            }
        }
        return new PriorityQueue<>(result);
    }

    /**
     * 区间合并
     * @param intervals 区间列表
     * @return 合并结果
     */
    private int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
    /**
     * 处理端口段
     * @param ports 端口段
     * @return 端口段
     */
    private List<String> segmentPort(String ports){
        final int threshold = 1000;
        String[] split = ports.split("-");
        List<String> list = new ArrayList<>();
        if (split.length==1){
            list.add(split[0]);
            return list;
        }
        int left = Integer.parseInt(split[0]);
        int right = Integer.parseInt(split[1]);
        double count = right - left +1;
        if (count<threshold){
            list.add(left +"-"+ right);
            return list;
        }
        list.add(left+"-"+(left + threshold-1));
        double loop = Math.ceil(count/threshold);
        for (int i = 1; i < loop; i++) {
            int preRight = Integer.parseInt(list.get(i-1).split("-")[1]);
            int currLeft = preRight +1;
            int currRight = preRight + threshold;
            if (currLeft== right){
                list.add(currLeft+"");
            } else if (currLeft< right && currRight> right){
                list.add(currLeft+"-"+ right);
            }else {
                list.add((preRight +1)+"-"+(preRight +threshold));
            }
        }
        return list;
    }
}
