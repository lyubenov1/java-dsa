package com.test.TwoPointers.easy;

public class MajorityElement {

    public static int majorityElement(int[] num) {
        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int result = majorityElement(nums);
        System.out.println("Output: " + result);
    }
}
