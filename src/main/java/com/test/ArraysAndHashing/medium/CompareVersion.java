package com.test.ArraysAndHashing.medium;

public class CompareVersion {

    public static int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0", "1.0.1")); // Output: -1
        System.out.println(compareVersion("1.0.1", "1.0.0")); // Output: 1
        System.out.println(compareVersion("2.1", "2.1")); // Output: 0
        System.out.println(compareVersion("1.0", "1.0")); // Output: 0
        System.out.println(compareVersion("1.0", "1")); // Output: 0
    }
}
