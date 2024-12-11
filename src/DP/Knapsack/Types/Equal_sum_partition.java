package DP.Knapsack.Types;

public class Equal_sum_partition {

    public boolean equalPartition(int arr[]) {
        int n = arr.length; // Length of the array
        int sum = 0; // Variable to store the total sum of the array elements

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }

        // If the total sum is odd, it is impossible to partition into two equal subsets
        if (sum % 2 != 0)
            return false;

        // The target sum for one subset
        int req_sum = sum / 2;

        // Create a DP table to store results for subproblems
        boolean[][] t = new boolean[n + 1][req_sum + 1];

        // Initialize the DP table
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < req_sum + 1; j++) {
                // If there are no elements, we cannot form a non-zero sum
                if (i == 0)
                    t[i][j] = false;

                // If the sum is zero, an empty subset can always achieve this
                if (j == 0)
                    t[i][j] = true;
            }
        }

        // Fill the DP table using a bottom-up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < req_sum + 1; j++) {
                // If the current element can be included in the subset
                if (arr[i - 1] <= j) {
                    // Check if including or excluding the current element achieves the target sum
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    // If the current element is greater than the target sum, exclude it
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // The result is stored in the last cell of the table
        return t[n][req_sum];
    }
}