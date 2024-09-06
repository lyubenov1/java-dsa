package com.test.Heap;

import java.util.*;

class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

        System.out.println(kthLargest.add(3)); // Should return 4
        System.out.println(kthLargest.add(5)); // Should return 5
        System.out.println(kthLargest.add(10)); // Should return 5
        System.out.println(kthLargest.add(9)); // Should return 8
        System.out.println(kthLargest.add(4)); // Should return 8
    }
}