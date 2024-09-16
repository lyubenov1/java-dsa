package com.test.ArraysAndHashing.medium;

import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] inputArr = {100, 4, 200, 1, 3, 2};
        int result = solution(inputArr);
        System.out.println(result);
    }

    private static int solution(int[] inputArr) {
        Set<Integer> set = new HashSet<>();
        for (int num : inputArr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : inputArr) {
            if (!set.contains(num - 1)) {
                int length = 1;

                while (set.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    /*
    public static int solution(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int globalMax = 1;
        int currentMax = 1;

        for (int i = 1; i < nums.length; i++) {
            // Skip duplicates
            if (nums[i] == nums[i - 1]) continue;

            // If the current element is consecutive to the previous one
            if (nums[i] == nums[i - 1] + 1) {
                currentMax++;
            } else {
                // If the sequence breaks, update the global max if needed
                globalMax = Math.max(globalMax, currentMax);
                currentMax = 1;
            }
        }

        return Math.max(globalMax, currentMax);
    }
     */
}
