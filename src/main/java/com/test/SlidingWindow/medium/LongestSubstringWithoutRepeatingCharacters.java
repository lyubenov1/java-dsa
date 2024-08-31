package com.test.SlidingWindow.medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "qrsvbspk";
        int longest = solution(str);
        System.out.println(longest);
    }

    private static int solution(String str) {
        int l = 0;
        Set<Character> charSet = new HashSet<>();
        char[] charArr = str.toCharArray();
        int length = charArr.length;
        int longest = 0;

        for (int r = 0; r < length; r++) {
            while (charSet.contains(str.charAt(r))) {
                charSet.remove(str.charAt(l));
                l++;
            }
            charSet.add(charArr[r]);
            longest = Math.max(longest, charSet.size());
        }

        return longest;
    }
}
