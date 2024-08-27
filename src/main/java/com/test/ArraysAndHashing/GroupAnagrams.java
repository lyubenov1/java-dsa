package com.test.ArraysAndHashing;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = solution(strings);
        System.out.println(groups);
    }

    private static List<List<String>> solution(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            char[] charArr = new char[26];

            // Count frequency of each letter in the string using the ASCII value of the char
            for (char c : s.toCharArray()) {
                charArr[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (char c : charArr) {
                sb.append(c).append("#");
            }

            String computedStr = sb.toString();
            map.putIfAbsent(computedStr, new ArrayList<>());
            map.get(computedStr).add(s);
        }

        return new ArrayList<>(map.values());
    }


    // Solution using sorting
    /*
    private static List<List<String>> solution(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);

            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
    */
}
