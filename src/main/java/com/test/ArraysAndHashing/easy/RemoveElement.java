package com.test.ArraysAndHashing.easy;

import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int i = 0; // Pointer for the next position of non-val elements
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i; // Number of elements not equal to val
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3; // Value to remove

        int k = removeElement(nums, val);

        System.out.println("Output: " + k);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
