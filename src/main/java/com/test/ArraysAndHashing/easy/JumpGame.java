package com.test.ArraysAndHashing.easy;

public class JumpGame {
    static boolean canJump(int[] nums) {
        int last = nums.length - 1;

        for(int i = last; i >= 0; i--){
            if(i + nums[i] >= last) {
                last = i;
            }
        }
        return last <= 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean canJump = canJump(nums);
        System.out.println(canJump);
    }
}
