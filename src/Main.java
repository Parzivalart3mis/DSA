import DP.Knapsack.*;
import DP.Knapsack.Types.*;
import DP.Knapsack.Unbounded_Knapsack.*;
import DP.LCS.*;

public class Main {
    public static void main(String[] args) {
        // Sample input for the knapsack problem
        int[] weights = {1, 3, 4, 5}; // weights of items
        int[] values = {1, 4, 5, 7};  // values of items
        int capacity = 7;             // maximum weight capacity of the knapsack
        int n = weights.length;       // number of items

        // Testing Recursion approach
        Recursion_knapsack recursion_knapsack = new Recursion_knapsack();
        int recursionResult = recursion_knapsack.knapsack(weights, values, capacity, n);
        System.out.println("Maximum profit using Recursion approach: " + recursionResult);

        // Testing Memoization approach
        Memoization_knapsack memoization_knapsack = new Memoization_knapsack();
        int memoizationResult = memoization_knapsack.knapsack(weights, values, capacity, n);
        System.out.println("Maximum profit using Memoization approach: " + memoizationResult);

        // Testing Top-down approach
        Topdown_knapsack topdown_knapsack = new Topdown_knapsack();
        int topdownResult = topdown_knapsack.knapsack(weights, values, capacity, n);
        System.out.println("Maximum profit using Top-down approach: " + topdownResult);

        // --------------------------------------------------------------------------
        System.out.println("--------------------------------------------------------------------------");
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

        // Testing Minimum Subset Sum Problem
        int[] nums = {1, 6, 11, 5}; // Example array for minimum subset sum difference
        Minimum_subset_sum_diff minimumDiff = new Minimum_subset_sum_diff();
        int minimumDiffResult = minimumDiff.minimumDifference(nums);
        System.out.println("Minimum subset sum difference: " + minimumDiffResult);

        // --------------------------------------------------------------------------

        // Testing Count Subsets with Given Difference
        int[] diffArray = {1, 1, 2, 3};
        int diff = 1;
        Count_subset_with_given_diff countDiff = new Count_subset_with_given_diff();
        int countDiffResult = countDiff.countSubsets(diffArray, diff);
        System.out.println("Number of subsets with given difference (" + diff + "): " + countDiffResult);

        // --------------------------------------------------------------------------

        // Testing Target Sum Problem
        int[] targetArray = {1, 1, 1, 1, 1};
        int target = 3;
        Target_sum targetSumSolver = new Target_sum();
        int targetSumResult = targetSumSolver.findTargetSumWays(targetArray, target);
        System.out.println("Number of ways to assign symbols to make target " + target + ": " + targetSumResult);

        // --------------------------------------------------------------------------
        System.out.println("--------------------------------------------------------------------------");
        // --------------------------------------------------------------------------

        // Unbounded Knapsack
        int[] unbounded_weights = {1, 3, 4, 5};
        int[] unbounded_values = {6, 1, 7, 7};
        int unbounded_capacity = 8;

        Unbounded_knapsack unboundedKnapsack = new Unbounded_knapsack();
        int maxProfit = unboundedKnapsack.unbound_knapsack(unbounded_weights, unbounded_values, unbounded_capacity, unbounded_weights.length);

        System.out.println("Maximum profit in Unbounded Knapsack: " + maxProfit);

        // --------------------------------------------------------------------------

        // Rod Cutting Problem
        int[] rodLengths = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] rodPrices = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;

        Rod_cutting rodCutting = new Rod_cutting();
        int maxProfitRodCutting = rodCutting.rod(rodLengths, rodPrices, rodLength);

        System.out.println("Maximum profit in Rod Cutting: " + maxProfitRodCutting);

        // --------------------------------------------------------------------------

        // Coin Change Problem 1: Maximum number of ways to make a sum
        int[] coinDenominations = {1, 2, 3}; // Coin denominations
        int targetAmount = 5; // Target sum to achieve

        Coin_change_1 coinChange = new Coin_change_1();
        int numWays = coinChange.maxCoinChange(coinDenominations, targetAmount);

        System.out.println("Number of ways to make amount " + targetAmount + " using given coins: " + numWays);

        // --------------------------------------------------------------------------

        // Coin Change Problem 2: Minimum number of coins to make a sum
        int[] coinDenominations2 = {1, 2, 3}; // Coin denominations
        int targetAmount2 = 5; // Target sum to achieve

        Coin_change_2 coinChange2 = new Coin_change_2();
        int minCoins = coinChange2.minCoinChange(coinDenominations2, targetAmount2);

        System.out.println("Minimum number of coins needed to make amount " + targetAmount2 + ": " + minCoins);

        // --------------------------------------------------------------------------
        System.out.println("--------------------------------------------------------------------------");
        // --------------------------------------------------------------------------

        // Sample input for LCS
        String text1 = "abcabcdede"; // String 1
        String text2 = "ace"; // String 2
        int m_LCS = text1.length(); // Length of text1
        int n_LCS = text2.length(); // Length of text2

        // Testing Recursion approach
        Recursion_LCS recursion_LCS = new Recursion_LCS();
        int recursionLCSLength = recursion_LCS.longestCommonSubsequence(text1, text2, m_LCS, n_LCS);
        System.out.println("Length of Longest Common Subsequence using Recursion approach: " + recursionLCSLength);

        // Testing Memoization approach
        Memoization_LCS memoizationLcs = new Memoization_LCS();
        int memoizationLCSLength = memoizationLcs.longestCommonSubsequence(text1, text2, m_LCS, n_LCS);
        System.out.println("Length of Longest Common Subsequence using Memoization approach: " + memoizationLCSLength);

        // Testing Top-down approach
        Topdown_LCS topdownLcs = new Topdown_LCS();
        int topdownLCSLength = topdownLcs.longestCommonSubsequence(text1, text2, m_LCS, n_LCS);
        System.out.println("Length of Longest Common Subsequence using Top-down approach: " + topdownLCSLength);
    }
}