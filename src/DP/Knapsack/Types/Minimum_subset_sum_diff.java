package DP.Knapsack.Types;

import java.util.ArrayList;

public class Minimum_subset_sum_diff {
    boolean[][] t; // DP table to track subset sums

    public int minimumDifference(int[] nums) {
        int n = nums.length; // Number of elements in the array
        int range = 0; // Total sum of all elements
        int mn = Integer.MAX_VALUE; // Variable to store the minimum difference
        ArrayList<Integer> arr = new ArrayList<>(); // List to store possible subset sums

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            range += nums[i];
        }

        // Initialize the DP table to track subset sums
        t = new boolean[n + 1][range + 1];

        // Base case: A sum of 0 is always possible (empty subset)
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = true;
        }

        // Base case: A non-zero sum is not possible with zero elements
        for (int j = 0; j < range + 1; j++) {
            t[0][j] = false;
        }

        // Populate the DP table using the subset sum logic
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < range + 1; j++) {
                if (nums[i - 1] <= j) {
                    // Include or exclude the current element
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                } else {
                    // Exclude the current element
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // Find all subset sums up to half the total sum (Since S1 + S2 = range, therefore S2 = range - S1, so we have to calculate range - 2*S1 later)
        for (int j = 1; j <= range / 2; j++) {
            if (t[n][j]) { // Check if subset with n elements with sum 'j' is possible
                arr.add(j); // Add it to the list of possible subset sums
            }
        }

        // Calculate the minimum difference between two subsets
        for (int i = 0; i < arr.size(); i++) {
            // Minimum difference is |range - 2 * subsetSum|
            mn = Math.min(mn, range - (2 * arr.get(i)));
        }

        // Return the minimum difference
        return mn;
    }
}