package DP.Knapsack;
import static java.lang.Math.max;

// Top-down approach to solve the 0/1 Knapsack problem
// Converts the recursive solution to an iterative dynamic programming solution using a 2D matrix
public class Topdown_knapsack {
    int[][] t; // Matrix to store the results of subproblems

    // Method to solve the knapsack problem
    public int knapsack(int[] wt, int[] val, int w, int n) {
        // Initialize the matrix to hold results for weights (0 to w) and items (0 to n)
        t = new int[n+1][w+1];

        // Base condition of recursion translated to DP table initialization
        // If there are no items (i = 0) or the capacity is zero (j = 0), the max value is 0
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // Fill the DP table iteratively
        for (int i = 1; i < n+1; i++) { // Iterate over items
            for (int j = 1; j < w+1; j++) { // Iterate over weight capacities
                // Check if the weight of the current item (wt[i-1]) is less than or equal to the current capacity (j)
                if (wt[i-1] <= j) {
                    // Take the maximum of:
                    // 1. Value of the current item + value of remaining capacity after including it
                    // 2. Value of not including the current item
                    t[i][j] = max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                } else {
                    // If the current item's weight is more than the current capacity, we can't include it
                    t[i][j] = t[i-1][j];
                }
            }
        }

        // The bottom-right corner of the table contains the maximum value for the given capacity and items
        return t[n][w];
    }
}
