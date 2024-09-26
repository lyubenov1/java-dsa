package com.test.ArraysAndHashing.easy;

public class JumpGameII {
    static int jump(int[] nums) {
        int res = 0;
        int l = 0;
        int r = 0;

        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int jumps = jump(nums);  // The minimum number of jumps to reach the last index
        System.out.println(jumps);
    }

}
