package DP.LCS;

public class Recursion_LCS {
    public int longestCommonSubsequence(String text1, String text2, int m, int n) {
        // Base case: if either string is empty, the LCS is 0.
        if (m == 0 || n == 0) {
            return 0;
        }

        // Check if the last characters of both strings are the same.
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            // If they match, include this character in the LCS
            // and recursively calculate the LCS for the remaining parts of both strings.
            return 1 + longestCommonSubsequence(text1, text2, m - 1, n - 1);
        } else {
            // If they do not match, recursively calculate the LCS in two scenarios:
            // 1. Exclude the last character of the first string.
            // 2. Exclude the last character of the second string.
            // Return the maximum of the two results.
            return Math.max(
                    longestCommonSubsequence(text1, text2, m - 1, n),
                    longestCommonSubsequence(text1, text2, m, n - 1)
            );
        }
    }
}