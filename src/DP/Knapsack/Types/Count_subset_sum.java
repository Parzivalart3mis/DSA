package DP.Knapsack.Types;

public class Count_subset_sum {
    // Declare a 2D array for memoization
    int[][] t;

    public int subset(int[] arr, int sum, int n) {
        // Initialize the memoization table with size [n+1][sum+1]
        t = new int[n + 1][sum + 1];

        // Base case: When sum is 0, there is always 1 subset (the empty subset)
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = 1;
        }

        // Base case: When there are no elements, no subset can form a non-zero sum
        for (int j = 0; j < sum + 1; j++) {
            t[0][j] = 0;
        }

        // Fill the table using a bottom-up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // If the current element is less than or equal to the current sum
                if (arr[i - 1] <= j) {
                    // Include the current element in the subset and exclude it
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    // Exclude the current element from the subset
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // Return the result stored in the last cell, which contains the count of subsets
        // that sum up to the given target
        return t[n][sum];
    }
}