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

        // --------------------------------------------------------------------------

        // Testing Count Subset Sum Problem
        int[] countSubsetArray = {2, 3, 5, 6, 8, 10}; // Example array for counting subsets
        int countSubsetSum = 10; // Target sum to check
        Count_subset_sum countSubsetSumSolver = new Count_subset_sum();
        int countSubsetResult = countSubsetSumSolver.subset(countSubsetArray, countSubsetSum, countSubsetArray.length);
        System.out.println("Number of subsets with sum " + countSubsetSum + ": " + countSubsetResult);

        // --------------------------------------------------------------------------

        // Testing Minimum Subset Sum Difference Problem
        int[] nums = {1, 6, 11, 5}; // Example array for minimum subset sum difference
        Minimum_subset_sum_diff minimumDiff = new Minimum_subset_sum_diff();
        int minimumDiffResult = minimumDiff.minimumDifference(nums);
        System.out.println("Minimum subset sum difference: " + minimumDiffResult);

        // --------------------------------------------------------------------------

        // Testing Count Subset with Given Difference Problem
        int[] diffArray = {1, 1, 2, 3}; // Example array for count subsets with given difference
        int diff = 1; // Target difference
        Count_subset_with_given_diff countSubsetDiffSolver = new Count_subset_with_given_diff();
        int countDiffResult = countSubsetDiffSolver.countSubsets(diffArray, diff);
        System.out.println("Number of subsets with the given difference (" + diff + "): " + countDiffResult);
    }
}
