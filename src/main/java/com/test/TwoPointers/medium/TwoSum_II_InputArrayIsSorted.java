package com.test.TwoPointers.medium;

import java.util.*;

public class TwoSum_II_InputArrayIsSorted {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 10, 11};
        int target = 9;

        int[] resultArr = solution(arr, target);

        if (resultArr.length > 0) {
            System.out.println(Arrays.toString(resultArr));
        } else {
            System.out.println("Not Found");
        }
    }

    private static int[] solution(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            if (arr[l] + arr[r] > target) {
                r--;
            } else if (arr[l] + arr[r] < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[0];
    }
}
