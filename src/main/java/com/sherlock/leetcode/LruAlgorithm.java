package com.sherlock.leetcode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 *
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 *
 *
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @author Sherlock
 * @date 2022/1/5 10:40
 * @describe 简单实现LRU算法 最少使用淘汰机制
 *
 *
 * 实现思路 :用hash表 (主要是用于查询 以及大小统计 ) 加双链表 (主要是用于记录前后关系)
 */
public class LruAlgorithm {

    private Map<Object, Node> map = new ConcurrentHashMap<>();

    /**
     * 双向链表 头部
     */
    private Node head;
    /**
     * 双向链表尾部
     */
    private Node tail;
    /**
     * 容量大小
     */
    private int capacity = 1024;

    private int size = map.size();

    public LruAlgorithm(int capacity){
        if (capacity<0){
            throw new IllegalArgumentException("capacity is not allow less than 0");
        }
        //初始化容类
        this.capacity = capacity;
        // 头部节点与尾部节点相连 利用虚拟头节点和尾节点
        //  head -> tail
        //  head <- tail

        head = new Node();
        tail = new Node();
        head.nextNode = tail;
        head.preNode = null;
        tail.nextNode = null;
        tail.preNode = head;
    }


    public void put(int key ,int value){
        //先查询是否存在key
        Node node = map.get(key);
        //如果缓存中没有,则需要新增节点至头部
        if (node == null ){
            //如果map 大小等于最大容量 则需要移除尾部
            if (map.size() == capacity){
                //删除map中的数据
                map.remove(tail.preNode.key);
                //删除双链表中的末尾节点
                removeLastNode();
            }
            //如果没有大于容量大小 则新插入到头部
            node = new Node(key,value);
            map.put(key,node);
            addToHead(node);
        }
        //如果存在则将当前节点移动至头节点
        //覆盖值
        node.value = value;
        //同时覆盖哈希表中的节点
        map.put(key,node);
        moveToHead(node);
    }


    public int get(int key){
        Node node = map.get(key);
        if (node!=null){
            //将当前节点移动至头节点
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    /**
     *  head -> 1 ->2 -> tail
     * @param node
     *
     *  node.prev = head;
     *         node.next = head.next;
     *         head.next.prev = node;
     *         head.next = node;
     */
    private void addToHead(Node node){
        //先结关系
        node.preNode = head;
        node.nextNode = head.nextNode;
        //再断关系
        head.nextNode.preNode = node;
        head.nextNode = node;
    }


    private void removeNode(Node node){
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
    }

    private void removeLastNode(){
        Node lastNode = tail.preNode;
        removeNode(lastNode);
    }

    private void moveToHead(Node node){
        //删除节点
        removeNode(node);
        //将节点插入头部
        addToHead(node);
    }


    static class Node{
        private int key;
        private int value;
        private Node preNode,nextNode;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
        public Node(){}
    }


    public static void main(String[] args) {
        LruAlgorithm lruAlgorithm = new LruAlgorithm(2);
//        lruAlgorithm.put(1,1);
//        lruAlgorithm.put(2,2);
//        int i = lruAlgorithm.get(1);
//        System.out.println(i);
//        int j = lruAlgorithm.get(2);
//        System.out.println(j);
//        int ki = lruAlgorithm.get(3);
//        System.out.println(ki);

        lruAlgorithm.put(2, 1); // 缓存是 {1=1}
        lruAlgorithm.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lruAlgorithm.get(1));    // 返回 1
        lruAlgorithm.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lruAlgorithm.get(2));   // 返回 -1 (未找到)
        lruAlgorithm.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lruAlgorithm.get(1));    // 返回 -1 (未找到)
        System.out.println(lruAlgorithm.get(3));    // 返回 3
        System.out.println(lruAlgorithm.get(4));    // 返回 4
    }
}
