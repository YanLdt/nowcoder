package com.yanl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YanL
 * @date 14:10 2020/9/4
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作：
 * 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，
 * 则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，
 * 从而为新的数据值留出空间。
 *
 * 分析
 * 使用双向链表+hashMap实现，
 * 双向链表按照使用的顺序来存储这些节点，靠近头部的为最近使用的
 * hashMap存储hash映射，键值与对应节点之前的映射，实现O(1)的查找
 * 当获取一个元素的时候，首先使用hashMap映射判断当前key是否存在
 * -存在则返回当前节点的值，并将当前节点移到头部
 * -不存在就返回-1；
 * 当插入一个元素的时候，首先判断
 * -1.是否已经存在对应的key
 * -如果存在对应的key,则覆盖原来节点的值
 * -不存在的话先创建对应的节点并加入到头部节点
 * 2.容量是否超出限制
 *  * -超出限制则移除尾部节点，
 *  * -没有超出限制将当前待插入元素插入头部
 *
 *  需要的功能有
 *  移动到头节点，
 *  插入到头节点
 *  移除节点
 *
 *
 *
 */

public class L0146LRUCache {
    /**
     * 双向链表节点类
     */
    class LRUNode{
        int key;
        int value;
        LRUNode pre;
        LRUNode next;

        public LRUNode(){};

        public LRUNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer, LRUNode> cache = new HashMap<>();
    /**
     *  伪头节点和尾节点
     */
    private LRUNode head;
    private LRUNode tail;
    /**
     * 链表容量
     * 如果超过这个容量则需要删除最近最少使用的元素
     */
    private int capacity;
    /**
     * 链表大小
     */
    private int size;

    public L0146LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 获取节点值
     * @param key
     * @return
     */
    public int get(int key) {
        LRUNode node = cache.get(key);
        //key不存在就返回-1
        if(node == null){
            return -1;
        }
        //存在的话将节点移到头部，返回节点值
        moveToHead(node);
        return node.value;
    }

    /**
     * 插入节点
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        //尝试从cache中获取节点
        LRUNode node = cache.get(key);
        if(node == null){
            //节点不存在就创建一个新节点
            LRUNode newNode = new LRUNode(key, value);
            //加入到hashMap中
            cache.put(key, newNode);
            //将节点插入到头部
            addToHead(newNode);
            //判断是否超过容量
            size++;
            //超过容量要移除节点并从map中移除对应键值
            if(size > capacity){
                LRUNode last = removeTail();
                cache.remove(last.key);
                size--;
            }
        }else {
            //如果节点存在就更新节点值，并移到头部
            node.value = value;
            moveToHead(node);
        }

    }

    /**
     * 将节点放在头部
     * @param node
     */
    private void addToHead(LRUNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * 将节点移到头部
     * 先移除
     * 再插入
     * @param node
     */
    private void moveToHead(LRUNode node){
        removeNode(node);
        addToHead(node);
    }

    /**
     * 从链表中移除一个节点
     * 当前节点的前一个节点的只想当前节点的后一个节点
     * @param node
     */
    private void removeNode(LRUNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 移除尾节点并返回当前节点  尾节点就是   tail.pre
     * 以便从hashMap中移除对应key
     *
     * @param
     * @return
     */
    private LRUNode removeTail(){
        LRUNode res = tail.pre;
        removeNode(res);
        return res;
    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */