import DP.Knapsack.*;
import DP.Knapsack.Types.*;

public class Main {
    public static void main(String[] args) {
        // Sample input for the knapsack problem
        int[] weights = {1, 3, 4, 5}; // weights of items
        int[] values = {1, 4, 5, 7};  // values of items
        int capacity = 7;             // maximum weight capacity of the knapsack
        int n = weights.length;       // number of items

        // Testing Recursion approach
        Recursion recursion = new Recursion();
        int recursionResult = recursion.knapsack(weights, values, capacity, n);
        System.out.println("Maximum profit using Recursion approach: " + recursionResult);

        // Testing Memoization approach
        Memoization memoization = new Memoization();
        int memoizationResult = memoization.knapsack(weights, values, capacity, n);
        System.out.println("Maximum profit using Memoization approach: " + memoizationResult);

        // Testing Top-down approach
        Topdown topdown = new Topdown();
        int topdownResult = topdown.knapsack(weights, values, capacity, n);
        System.out.println("Maximum profit using Top-down approach: " + topdownResult);

        // --------------------------------------------------------------------------

        // Testing Subset Sum Problem
        int[] subsetArray = {3, 34, 4, 12, 5, 2}; // Example array for subset sum
        int subsetSum = 9; // Target sum to check
        Subset_sum subsetSumSolver = new Subset_sum();
        boolean subsetResult = subsetSumSolver.subset(subsetArray, subsetSum, subsetArray.length);
        System.out.println("Is there a subset with sum " + subsetSum + "? " + (subsetResult ? "Yes" : "No"));

        // --------------------------------------------------------------------------

        // Testing Equal Sum Partition Problem
        int[] arr = {1, 5, 11, 5}; // Example array for equal sum partition
        Equal_sum_partition equalSumPartitionSolver = new Equal_sum_partition();
        boolean equalPartitionResult = equalSumPartitionSolver.equalPartition(arr);
        System.out.println("Can the array be partitioned into two subsets with equal sum? " + (equalPartitionResult ? "Yes" : "No"));
    }
}
