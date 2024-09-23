package com.test.TwoPointers.medium;

import java.util.*;

public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = removeDuplicates(nums);

        System.out.println("Output: " + k);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
