package com.test.SlidingWindow;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        // Expected: 5 (profit: 6 - 1 == 5)
        int maxProfit = solution(prices);
        System.out.println(maxProfit);
    }

    public static int solution(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) min = price;
            else if (price > min) max = Math.max(price - min, max);
        }
        return max;
    }

    /*
    private static int solution(int[] prices) {
        int l = 0, r = 1;
        int maxProfit = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }

     */
}
