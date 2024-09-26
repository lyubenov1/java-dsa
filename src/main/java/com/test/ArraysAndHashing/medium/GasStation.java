package com.test.ArraysAndHashing.medium;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;  // Total surplus of gas across all stations
        int surplus = 0;  // Surplus at the current station
        int start = 0;  // Starting index of the journey

        for (int i = 0; i < n; i++) {
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];

            // If surplus is negative, this station can't be the start
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }

        // If the total surplus is negative, it's impossible to complete the circuit
        return (total_surplus < 0) ? -1 : start;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int startStation = canCompleteCircuit(gas, cost);
        System.out.println("Starting station: " + startStation);
    }
}
