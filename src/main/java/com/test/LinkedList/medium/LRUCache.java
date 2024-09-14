package com.test.LinkedList.medium;

import com.test.LinkedList.*;

import java.util.HashMap;

public class LRUCache {
    private final HashMap<Integer, DLinkedNode> cache; // Map from key to node
    private int count; // Current number of elements in the cache
    private final int capacity; // Maximum capacity of the cache
    private final DLinkedNode head; // Dummy head of the doubly linked list
    private final DLinkedNode tail; // Dummy tail of the doubly linked list

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;

        cache = new HashMap<>();
    }

    // Add the new node right after the head
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // Remove an existing node from the doubly linked list
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.prev;
        DLinkedNode post = node.next;

        pre.next = post;
        post.prev = pre;
    }

    // Move a node to the head (most recently used position)
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // Remove the least recently used node (the one right before the tail)
    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        this.removeNode(res);
        return res;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // Key not found, return -1
        }

        // Move the accessed node to the head
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // Cache is full, remove the least recently used node
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // Key exists, update the value and move to head
            node.value = value;
            this.moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(1, 1); // Cache is {1=1}
        System.out.println(lRUCache.get(1)); // Returns 1

        lRUCache.put(2, 2); // Cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1)); // Returns 1

        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2)); // Returns -1 (not found)

        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1)); // Returns -1 (not found)
        System.out.println(lRUCache.get(3)); // Returns 3
        System.out.println(lRUCache.get(4)); // Returns 4
    }
}
