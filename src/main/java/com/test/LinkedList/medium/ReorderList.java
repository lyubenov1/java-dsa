package com.test.LinkedList.medium;

import com.test.LinkedList.easy.ReverseLinkedList.*;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Find the middle of the list
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // Reverse the half after middle
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while (preCurrent != null && preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        // Reorder one by one
        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode arrayToList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode head = arrayToList(arr);

        ReorderList solution = new ReorderList();
        solution.reorderList(head);

        System.out.print("Reordered List: ");
        printList(head);
    }

}