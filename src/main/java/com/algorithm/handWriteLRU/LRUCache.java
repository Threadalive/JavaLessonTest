package com.algorithm.handWriteLRU;

import java.util.Hashtable;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/12 16:46
 */
public class LRUCache {
    /**
     * cache
     */
    private Hashtable<String,DLinkNode> cache = new Hashtable<String, DLinkNode>();
    /**
     * 当前大小
     */
    private int count;
    /**
     * 容量大小
     */
    private int capacity;
    /**
     * 双向链表头尾结点
     */
    private DLinkNode head, tail;

    /**
     * 初始化固定容量的缓存大小
     * @param capacity 容量
     */
    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;

        head = new DLinkNode();
        head.pre = null;

        tail = new DLinkNode();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    /**
     * 获取
     * @param key
     * @return
     */
    public int get(String key){
        DLinkNode node = cache.get(key);
        if(node == null){
            return -1;
        }

        this.moveToHead(node);
        return node.value;
    }

    public void set(String key,int value){
        DLinkNode node = cache.get(key);

        if (node == null){
            DLinkNode newNode  = new DLinkNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key,newNode);
            this.addNode(newNode);

            count++;

            if(count > capacity){
                DLinkNode res = this.popTailNode();
                this.cache.remove(res.key);
                count--;
            }

        }else {
            node.value = value;
            this.moveToHead(node);
        }
    }


    private void moveToHead(DLinkNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    private void addNode(DLinkNode node){
        node.pre = head;
        node.next = head.next;

        head.next = node;
        node.next.pre = node;
    }

    private void removeNode(DLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 弹出最后一个元素
     * @return
     */
    private DLinkNode popTailNode(){
        DLinkNode node = tail.pre;
        removeNode(node);
        return node;
    }

    public void printLRUCache(){
        if (head.next == tail){
            System.out.println("空");
        }else {
            DLinkNode ptr = head.next;
        while (ptr != tail){
            System.out.println(ptr.value);
            ptr = ptr.next;
        }
        }
    }
}

class DLinkNode{
    String key;
    int value;
    DLinkNode pre;
    DLinkNode next;
}
class Test{
    public static void main(String args[]){
        LRUCache cache = new LRUCache(3);
        cache.set("1",1);
        cache.set("2",2);
        cache.set("3",3);

        cache.set("4",4);
        System.out.println(cache.get("2")+"\n");

        cache.printLRUCache();

    }

}