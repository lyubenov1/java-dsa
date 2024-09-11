package com.test.LinkedList.easy;

import com.test.LinkedList.easy.ReverseLinkedList.*;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 and fast by 2, check if they meet (cycle detection)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true; // Cycle detected
        }

        return false; // No cycle
    }

    public static ListNode createLinkedListWithCycle(int[] values, int pos) {
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = null;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) cycleNode = current;
        }

        // Create the cycle if pos is valid
        if (pos >= 0) {
            current.next = cycleNode; // Create the cycle by pointing tail to the pos node
        }

        return head;
    }

    public static void main(String[] args) {
        // Example: Input [3, 2, 0, -4], pos = 1 (cycle at index 1)
        int[] values = {3, 2, 0, -4};
        int pos = 1; // Tail connects to the 1st node

        LinkedListCycle solution = new LinkedListCycle();
        ListNode head = createLinkedListWithCycle(values, pos);

        // Check if the linked list has a cycle
        boolean hasCycle = solution.hasCycle(head);

        // Print the result
        System.out.println("Has cycle: " + hasCycle); // Output: true
    }
}
