package DP.LCS.Types;

public class Longest_common_substring {
    public int longestCommonSubstr(String s1, String s2, int m, int n) {
        int maxLength = 0; // Variable to store the maximum length of the common substring
        int[][] t = new int[m + 1][n + 1]; // DP table to store lengths of common substrings at each index pair

        // Initialize the first row and first column of the DP table to 0
        // This represents the base case: if one of the strings is empty, the LCS length is 0
        for (int i = 0; i <= m; i++) {
            t[i][0] = 0; // No substring can exist with an empty second string
        }
        for (int j = 0; j <= n; j++) {
            t[0][j] = 0; // No substring can exist with an empty first string
        }

        // Fill the DP table using a bottom-up approach
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Check if the current characters of both strings match
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If they match, add 1 to the diagonal value (t[i-1][j-1])
                    t[i][j] = 1 + t[i - 1][j - 1];
                    // Update the maximum length found so far
                    maxLength = Math.max(maxLength, t[i][j]);
                } else {
                    // If they do not match, reset the value to 0
                    // This ensures the substring continuity property
                    t[i][j] = 0;
                }
            }
        }

        // Return the maximum length of the common substring found
        return maxLength;
    }
}
