package DP.Knapsack;
import static java.lang.Math.max;
import java.util.Arrays;

////Recursion
//public class Knapsack {
//    public int knapsack(int[] wt, int[] val, int w, int n) {
//        if (w == 0 || n == 0) {
//            return 0;
//        }
//        if (wt[n - 1] <= w) {
//            return max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
//        } else {
//            return knapsack(wt, val, w, n - 1);
//        }
//    }
//}

////Memoization
//public class Knapsack {
//    int n_max = 102; // n < 100
//    int w_max = 1002; // w < 1000
//    int[][] t;
//
//    public Knapsack() {
//        t = new int[n_max][w_max];
//        for (int i = 0; i < n_max; i++) {
//            Arrays.fill(t[i], -1); // Using Arrays.fill to initialize each row to -1
//        }
//    }
//
//    public int knapsack(int[] wt, int[] val, int w, int n) {
//        if (w == 0 || n == 0) {
//            return 0;
//        }
//        if (t[n][w] != -1) {
//            return t[n][w];
//        }
//        if (wt[n - 1] <= w) {
//            t[n][w] = max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
//        } else {
//            t[n][w] = knapsack(wt, val, w, n - 1);
//        }
//        return t[n][w];
//    }
//}

//Top-down approach
public class Knapsack {
    // 2D array to store the maximum profit for sub-problems
    int[][] t;

    // Method to calculate maximum profit for a given weight limit `w` and `n` items
    public int knapsack(int[] wt, int[] val, int w, int n) {
        // Initialize the 2D DP table with dimensions (n+1) x (w+1)
        t = new int[n + 1][w + 1];

        // Base case initialization: if weight or items are 0, profit is 0
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // Fill the DP table following the top-down approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                // Check if the current item's weight can fit in the knapsack capacity `j`
                if (wt[i - 1] <= j) {
                    // If yes, we have two choices: include or exclude the item
                    // We take the maximum of both choices
                    t[i][j] = max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    // If the item can't fit, exclude it from the knapsack
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        // The maximum profit for capacity `w` with `n` items is stored in `t[n][w]`
        return t[n][w];
    }
}
