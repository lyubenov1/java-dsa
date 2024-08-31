package com.test.ArraysAndHashing.easy;

import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1};

        boolean result = solution(nums);
        System.out.println(result);
    }

    static boolean solution(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

}