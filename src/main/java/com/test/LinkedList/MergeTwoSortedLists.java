package com.test.LinkedList;

import com.test.LinkedList.ReverseLinkedList.*;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
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
        int[] list1Arr = {1, 2, 4};
        int[] list2Arr = {1, 3, 4};

        ListNode list1 = arrayToList(list1Arr);
        ListNode list2 = arrayToList(list2Arr);

        ListNode mergedList = mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(mergedList);
    }
}