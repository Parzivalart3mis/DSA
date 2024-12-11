package DP.Knapsack.Types;

public class Subset_sum {
    boolean[][] t; // DP table to track if a subset sum is possible

    // Function to check if there is a subset with the given sum
    public boolean subset(int[] arr, int sum, int n) {
        // Initialize the DP table where t[i][j] will be true if
        // a subset with sum j is possible using the first i elements
        t = new boolean[n + 1][sum + 1];

        // Base case: A sum of 0 is always possible (empty subset)
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = true;
        }

        // Base case: A non-zero sum is not possible with zero elements
        for (int j = 0; j < sum + 1; j++) {
            t[0][j] = false;
        }

        // Populate the DP table using the subset sum logic
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    // If current element can be included in the subset
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    // If current element cannot be included in the subset
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // Return whether a subset with the given sum is possible
        return t[n][sum];
    }
}