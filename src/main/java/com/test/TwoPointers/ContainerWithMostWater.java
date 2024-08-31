package com.test.TwoPointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = solution(array);

        // Expected: 49
        System.out.println(area);
    }

    private static int solution(int[] array) {
        int l = 0;
        int r = array.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (l < r) {
            int currentArea = (r - l) * Integer.min(array[l], array[r]);
            if (maxArea < currentArea) {
                maxArea = currentArea;
            }

            if (array[l] < array[r]) {
                l++;
            } else if (array[l] > array[r]) {
                r--;
            } else { // Equal heights edge case
                if (array[l + 1] < array[r - 1]) {
                    r--;
                } else if (array[l + 1] > array[r - 1]) {
                    l++;
                } else { // Equal heights. In that case, which pointer we shift is irrelevant
                    l++;
                }
            }
        }
        return maxArea;
    }
}
