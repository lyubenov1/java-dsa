package com.test.TwoPointers.easy;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean isPalindrome = solution(s);
        System.out.println(isPalindrome);
    }

    private static boolean solution(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int start = 0;
        int last = s.length() - 1;

        while(start <= last) {
            char currLeft = s.charAt(start);
            char currRight = s.charAt(last);

            if (!Character.isLetterOrDigit(currLeft)) {
                start++;
            } else if (!Character.isLetterOrDigit(currRight)) {
                last--;
            } else {
                if (Character.toLowerCase(currLeft) != Character.toLowerCase(currRight)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}
