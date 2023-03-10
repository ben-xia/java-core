package com.ben.java.algorithm.leetcode;

import java.util.HashMap;

/**
 * @author: ben.xia
 * @desc:  0(1)
 * @date: 2023/3/10
 */
public class LRUCache {
    private HashMap<Integer,Node> lruCache;
    private int capacity;
    private Node dummyHead ;
    private Node dummyTail;
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.lruCache.keySet());

        int res1 = cache.get(1);
        System.out.println(res1);

        cache.put(3, 3);

        int res2 = cache.get(2);
        System.out.println(res2);

        int res3 = cache.get(3);
        System.out.println(res3);

        cache.put(4, 4);
        System.out.println(cache.lruCache.keySet());

        int res4 = cache.get(1);
        System.out.println(res4);

        int res5 = cache.get(3);
        System.out.println(res5);

        int res6 = cache.get(4);
        System.out.println(res6);
    }
    public LRUCache( int capacity) {
        lruCache = new HashMap<>(capacity);
        this.capacity = capacity;
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
        dummyHead.next=dummyTail;
        dummyTail.pre=dummyHead;
    }

    public int get(int key){
        if (lruCache.containsKey(key)){
            Node node = lruCache.get(key);
            moveNode2Head(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value){
        if (lruCache.containsKey(key)){
            Node node = lruCache.get(key);
            node.value=value;
            moveNode2Head(node);
            return;
        }
        //新增 1.未到容量 ;  2. 已经到达容量
        if (lruCache.size()==capacity){
            // 先删除
            removeLru(dummyTail.pre);
        }

        Node node = new Node(key, value);
        lruCache.put(key, node);
        addNode2Head(node);
    }

    private void removeLru(Node node) {
        Node pre = node.pre;
        dummyTail.pre=pre;
        pre.next=dummyTail;
        lruCache.remove(node.key);
    }


    private void moveNode2Head(Node node) {
        Node pre = node.pre;
        if (pre ==dummyHead){return;}
        Node next = node.next;
        next.pre=pre;
        pre.next=next;

        node.pre=dummyHead;
        node.next=dummyHead.next;
        dummyHead.next.pre=node;
        dummyHead.next=node;

    }

    private void addNode2Head(Node node){
        Node next = dummyHead.next;
        node.next=next;
        node.pre=dummyHead;
        next.pre=node;
        dummyHead.next=node;
    }
}
class Node{
    Node pre,next;
    Integer key,value;

    public Node() {
    }

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
