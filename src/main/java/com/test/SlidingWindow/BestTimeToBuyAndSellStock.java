package com.test.SlidingWindow;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int result = solution(prices);
        System.out.println(result);
    }

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
}
