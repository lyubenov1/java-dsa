package com.test.Heap.medium;

public class KthLargestElementInAnArray {

    // QuickSelect solution
    public static int findKthLargest(int[] nums, int k) {
        // Convert k-th largest to index in zero-based array
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, hi);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /* QuickSort solution
        public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        // the index of the kth largest element is nums.length - k.
        return nums[nums.length - k];
    }

    private static void quickSort(int[] nums, int start, int end)
    {
        if (start >= end)
            return;

        // use the center number as the pivot.
        int pivot = nums[(start+end)/2];
        int i = start, j = end;

        while (i <= j) {
            while(i <= j && nums[i] < pivot)
                i++;
            while(i <= j && pivot < nums[j])
                j--;
            //swap if nums[i] > nums[j] where nums[i] is in the left of pivot, and nums[j] is in the right of pivot.
            if (i <= j)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(nums, start, j);
        quickSort(nums, i, end);
    }
     */

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int output = findKthLargest(nums, k);
        System.out.println(output);
    }
}
