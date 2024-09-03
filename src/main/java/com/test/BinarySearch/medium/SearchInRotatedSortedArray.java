package com.test.BinarySearch.medium;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution(arr, target);
        System.out.println(result);
    }

    private static int solution(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[end]) {  // eg. 3,4,5,6,1,2
                if (target > arr[mid] || target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {  // eg. 5,6,1,2,3,4
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }

        if (start == end && target != arr[start]) return -1;

        return start;
    }
}
