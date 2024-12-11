package DP.LCS.Types;

public class Shortest_common_supersequence {
    public int shortestCommonSupersequence(String str1, String str2, int m, int n) {
        // Create a DP table to store the lengths of the Longest Common Subsequences (LCS)
        int[][] t = new int[m + 1][n + 1];

        // Initialize the first column of the DP table (when str2 is empty, LCS length is 0)
        for (int i = 0; i < m + 1; i++) {
            t[i][0] = 0;
        }

        // Initialize the first row of the DP table (when str1 is empty, LCS length is 0)
        for (int j = 0; j < n + 1; j++) {
            t[0][j] = 0;
        }

        // Fill the DP table based on the recurrence relation
        // If characters match, include the character in LCS and add 1 to the result
        // Otherwise, take the maximum of excluding the current character from either string
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // The length of the shortest common supersequence is calculated as:
        // Total length of both strings - Length of their Longest Common Subsequence (LCS)
        return (m + n - t[m][n]);
    }
}
