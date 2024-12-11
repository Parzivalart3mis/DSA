package DP.Knapsack.Types;

public class Count_subset_with_given_diff {
    int[][] t; // Memoization table to store intermediate results

    public int countSubsets(int[] arr, int diff) {
        int n = arr.length; // Length of the array
        int sum_arr = 0; // Total sum of the array

        // Calculate the total sum of the array
        for (int i : arr) {
            sum_arr += i;
        }

        // If (sum_arr + diff) is odd, no valid partition exists
        if ((sum_arr + diff) % 2 != 0) {
            return 0;
        }

        // Calculate the target sum (s1) for one subset
        int s1 = (sum_arr + diff) / 2;

        // Initialize the memoization table with size [n+1][s1+1]
        t = new int[n + 1][s1 + 1];

        // Base case: If sum is 0, there is always 1 subset (the empty subset)
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = 1;
        }

        // Base case: If there are no elements, no subset can form a non-zero sum
        for (int j = 0; j < s1 + 1; j++) {
            t[0][j] = 0;
        }

        // Fill the table using a bottom-up dynamic programming approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s1 + 1; j++) {
                // If the current element can be included in the subset
                if (arr[i - 1] <= j) {
                    // Include the current element or exclude it
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    // Exclude the current element from the subset
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // Return the result stored in the last cell of the table
        return t[n][s1];
    }
}
