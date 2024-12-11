package DP.LCS;

import java.util.Arrays;

public class Memoization_LCS {
    int m_max = 1001; // m < 100
    int n_max = 1001; // n < 1000
    int[][] t;

    public Memoization_LCS() {
        t = new int[m_max][n_max];
        for (int i = 0; i < n_max; i++) {
            Arrays.fill(t[i], -1); // Using Arrays.fill to initialize each row to -1
        }
    }

    public int longestCommonSubsequence(String text1, String text2, int m, int n) {
        // Base case: if either string is empty, the LCS is 0.
        if (m == 0 || n == 0) {
            return 0;
        }

        // Check if the result for the current subproblem is already computed.
        if (t[m][n] != -1) {
            return t[m][n];
        }

        // If the last characters of both strings match.
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            // Include the matching character in the LCS and solve for the remaining substrings.
            return t[m][n] = 1 + longestCommonSubsequence(text1, text2, m - 1, n - 1);
        } else {
            // If the last characters do not match, find the maximum LCS by:
            // 1. Excluding the last character of the first string.
            // 2. Excluding the last character of the second string.
            return t[m][n] = Math.max(
                    longestCommonSubsequence(text1, text2, m, n - 1),
                    longestCommonSubsequence(text1, text2, m - 1, n)
            );
        }
    }
}