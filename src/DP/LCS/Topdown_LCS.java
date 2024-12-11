package DP.LCS;

public class Topdown_LCS {
    public int longestCommonSubsequence(String text1, String text2, int  m, int n) {
        // In the table, each cell represents a sub-problem -> the length of LCS for lengths i and j be (indices for that cell).
        int[][] t = new int[m + 1][n + 1];

        // Initialize the base case:
        // If either string is empty (i == 0 or j == 0), the LCS is 0.
        for (int i = 0; i <= m; i++) {
            t[i][0] = 0; // First column (text2 is empty)
        }
        for (int j = 0; j <= n; j++) {
            t[0][j] = 0; // First row (text1 is empty)
        }

        // Fill the table using a bottom-up approach.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current characters of both strings match:
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Add 1 to the LCS of the previous characters (diagonal value).
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    // If characters do not match, take the maximum value from:
                    // 1. Excluding the current character of text1 (t[i-1][j]).
                    // 2. Excluding the current character of text2 (t[i][j-1]).
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // Return the value at the bottom-right corner, which represents the LCS of text1 and text2.
        return t[m][n];
    }
}
