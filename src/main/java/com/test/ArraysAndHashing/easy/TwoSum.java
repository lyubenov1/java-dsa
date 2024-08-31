package com.test.ArraysAndHashing.easy;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 7, 8, 11, 15};
        int target = 15;

        int[] resultArr = twoSum(arr, target);

        if (resultArr.length > 0) {
            System.out.println(Arrays.toString(resultArr));
        } else {
            System.out.println("Not Found");
        }
    }

    private static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{}; // No solution found
    }
}
