package com.test.ArraysAndHashing.hard;

import java.util.Arrays;

public class Candy {

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);  // Every child gets at least 1 candy

        // First pass (left to right): Ensure higher-rated children get more candies than the previous child
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Second pass (right to left): Ensure higher-rated children get more candies than the next child
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int totalCandies = candy(ratings);
        System.out.println("Total candies needed: " + totalCandies);
    }
}
