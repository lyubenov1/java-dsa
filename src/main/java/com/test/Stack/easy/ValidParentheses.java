package com.test.Stack.easy;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "{[()[]{}]}";
        boolean isValid = solution(s);
        System.out.println(isValid);
    }

    private static boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
