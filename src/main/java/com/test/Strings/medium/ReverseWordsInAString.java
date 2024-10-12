package com.test.Strings.medium;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        s = s.trim();

        String[] words = s.split("\\s+");

        StringBuilder reversed = new StringBuilder();
        for(int i = words.length -1 ; i>=0 ;i--){
            reversed.append(words[i]);
            if(i !=0){
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "the sky is blue";
        String output = reverseWords(input);
        System.out.println(output);
    }
}
