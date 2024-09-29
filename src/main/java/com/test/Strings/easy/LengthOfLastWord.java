package com.test.Strings.easy;

public class LengthOfLastWord {

    private static int solution(String s) {
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                if (length > 0) return length;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        int length = solution(s);
        System.out.println(length);
    }
}
