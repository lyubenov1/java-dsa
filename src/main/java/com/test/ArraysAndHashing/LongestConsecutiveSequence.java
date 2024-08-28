package com.test.ArraysAndHashing;

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
}
