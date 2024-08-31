package com.test.TwoPointers.medium;

import java.util.*;

class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = solution(nums);
        System.out.println(triplets);
    }

    private static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip the same element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // If the current number is greater than 0, stop the loop
            if (nums[i] > 0) break;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    output.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip the same elements to avoid duplicate triplets
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return output;
    }
}