package com.test.ArraysAndHashing;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 4, 7, 7, 4, 4, 3};
        int k = 2;
        int[] result = solution(arr, k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] freqArr = new ArrayList[arr.length + 1];
        for (int i = 0; i < freqArr.length; i++) {
            freqArr[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            freqArr[frequency].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = freqArr.length - 1; i >= 0; i--) {
            for (int num : freqArr[i]) {
                res[idx++] = num;
                if (idx == k) {
                    return res;
                }
            }
        }

        return new int[0];
    }
}
