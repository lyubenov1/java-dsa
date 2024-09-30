package com.test.Strings.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};

        System.out.println("Longest common prefix of strs1: " + longestCommonPrefix(strs1)); // Output: "fl"
        System.out.println("Longest common prefix of strs2: " + longestCommonPrefix(strs2)); // Output: ""
    }

    public static String longestCommonPrefix(String[] strs) {
        // Step 1: Sort the array of strings lexicographically
        Arrays.sort(strs);

        // Step 2: Get the first and last strings after sorting
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        // Step 3: Find the longest common prefix between the first and last strings
        int idx = 0;
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }

        // Step 4: Return the substring from the beginning to the index where characters matched
        return s1.substring(0, idx);
    }
}
