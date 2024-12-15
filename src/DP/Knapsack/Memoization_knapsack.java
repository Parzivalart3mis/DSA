package DP.Knapsack;
import static java.lang.Math.max;
import java.util.Arrays;

// Memoization approach to solve the Knapsack problem
public class Memoization_knapsack {
    int n_max = 102; // Maximum number of items (n < 100)
    int w_max = 1002; // Maximum weight capacity (w < 1000)
    int[][] t; // 2D array for memoization table

    // Constructor to initialize the memoization table with -1
    public Memoization_knapsack() {
        t = new int[n_max][w_max]; // Initialize the memoization table with appropriate size
        for (int i = 0; i < n_max; i++) {
            Arrays.fill(t[i], -1); // Using Arrays.fill to initialize each row to -1 (indicating uncalculated values)
        }
    }

    // knapsack function to calculate the maximum value that can be obtained with weight capacity w and n items
    public int knapsack(int[] wt, int[] val, int w, int n) {
        // Base case: If no items are left or the weight capacity is zero, no value can be obtained
        if (w == 0 || n == 0) {
            return 0;
        }

        // Check if the result is already computed (memoized), return the stored value if present
        if (t[n][w] != -1) {
            return t[n][w];
        }

        // If the current item's weight is less than or equal to the remaining capacity,
        // we have two options: either include it or exclude it
        if (wt[n - 1] <= w) {
            // Store the maximum value obtained by including or excluding the current item
            t[n][w] = max(
                    val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), // Include current item
                    knapsack(wt, val, w, n - 1) // Exclude current item
            );
        } else {
            // If the current item cannot be included (due to weight), exclude it
            t[n][w] = knapsack(wt, val, w, n - 1);
        }

        // Return the memoized value
        return t[n][w];
    }
}
