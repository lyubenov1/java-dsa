package com.test.ArraysAndHashing.medium;

import java.util.*;

public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    Random rand = new Random();

    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if (contain) return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if (!contain) return false;
        int loc = locs.get(val);  // Get the index of the value to be removed

        if (loc < nums.size() - 1) {  // If the value is not the last element in the list
            int lastOne = nums.getLast();  // Get the last element in the list
            nums.set(loc, lastOne);  // Overwrite the value at index 'loc' with the last element
            locs.put(lastOne, loc);  // Update the index of the last element in the hashmap
        }

        locs.remove(val);
        nums.removeLast();
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        // Test inserting values
        System.out.println(randomizedSet.insert(1));  // True
        System.out.println(randomizedSet.insert(2));  // True
        System.out.println(randomizedSet.insert(1));  // False, 1 already exists

        // Test removing values
        System.out.println(randomizedSet.remove(2));  // True
        System.out.println(randomizedSet.remove(3));  // False, 3 does not exist

        // Test getting a random element
        randomizedSet.insert(3);
        System.out.println(randomizedSet.getRandom());  // Should return 1 or 3 randomly
        System.out.println(randomizedSet.getRandom());  // Should return 1 or 3 randomly
    }
}