package DP.LCS.Types;

public class Longest_repeating_subsequence {

    // Function to find the length of the Longest Repeating Subsequence (LRS)
    public int LongestRepeatingSubsequence(String s, int m) {
        // Step 1: Create a DP table to store the lengths of the LRS
        int[][] t = new int[m + 1][m + 1];

        // Step 2: Initialize the first row and column with 0
        // This handles the base case where one of the sequences is empty
        for (int i = 0; i < m + 1; i++) {
            t[i][0] = 0; // No characters in the second sequence
            t[0][i] = 0; // No characters in the first sequence
        }

        // Step 3: Fill the DP table using the LRS recurrence relation
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // If characters match and their indices are different(i and j should be different to prove that the character is not present only once)
                // This condition ensures that we only consider the same characters appearing at different positions in the string.
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    t[i][j] = 1 + t[i - 1][j - 1]; // Include the character in the LRS
                } else {
                    // If characters don't match or indices are the same,
                    // take the maximum value of excluding a character from either sequence
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // Step 4: The value in t[m][m] contains the length of the LRS
        return t[m][m];
    }
}
