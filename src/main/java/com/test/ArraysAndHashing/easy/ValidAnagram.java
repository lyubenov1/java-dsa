package com.test.ArraysAndHashing.easy;

import java.util.*;

public class ValidAnagram {

    public static void main(String[] args) {
        // Test cases
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("hello", "world"));   // false
    }

    private static boolean isAnagram(String n, String t) {
        if (n.length() != t.length()) {
            return false;
        }

        char[] charArr1 = new char[26];
        char[] charArr2 = new char[26];

        for (char ch : n.toCharArray()) {
            charArr1[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            charArr2[ch - 'a']++;
        }

        return Arrays.equals(charArr1, charArr2);
    }

    /*
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Early exit if lengths are different
        }

        Map<Character, Integer> count = new HashMap<>();

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
     */
}