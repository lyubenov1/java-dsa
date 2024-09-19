package com.test.SlidingWindow.medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "qrsvbspk";
        int longest = solution(str);
        System.out.println(longest);
    }

    private static int solution(String str) {
        if (str.isEmpty()) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0, j = 0; i < str.length(); ++i) {
            if (map.containsKey(str.charAt(i))) {
                j = Math.max(j, map.get(str.charAt(i)) + 1);
            }
            map.put(str.charAt(i) , i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    /*
      private static int solution(String str) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }
     */
}
