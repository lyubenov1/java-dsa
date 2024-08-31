package com.test.ArraysAndHashing.medium;

import java.util.*;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = solution(nums);

        // Expected output : [24,12,8,6]
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] nums) {
        int n = nums.length;
        int[] resArr = new int[n];
        Arrays.fill(resArr, 1);
        int curr = 1;

        for(int i = 0; i < n; i++) {
            resArr[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;

        for(int i = n - 1; i >= 0; i--) {
            resArr[i] *= curr;
            curr *= nums[i];
        }

        return resArr;
    }


    /*
    private static int[] solution(int[] nums) {
        int n = nums.length;
        int[] prefixArr = new int[n];
        int[] suffixArr = new int[n];

        prefixArr[0] = 1;
        suffixArr[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefixArr[i] = prefixArr[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffixArr[i] = suffixArr[i + 1] * nums[i + 1];
        }

        int[] resArr = new int[n];
        for (int i = 0; i < n; i++) {
            resArr[i] = prefixArr[i] * suffixArr[i];
        }

        return resArr;
    }
     */
}
