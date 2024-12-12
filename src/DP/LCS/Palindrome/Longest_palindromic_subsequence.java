package DP.LCS.Palindrome;

public class Longest_palindromic_subsequence {

    // Helper method to reverse the string
    private String reverse(String s) {
        // Using StringBuilder to reverse the input string
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString(); // Returning the reversed string
    }

    // Method to find the longest palindromic subsequence
    public int longestPalindromeSubseq(String s, int n) {
        // Reverse the input string to compare characters with the original string
        String rev = reverse(s);

        // Initialize a 2D array for dynamic programming table to store results
        int[][] t = new int[n + 1][n + 1];

        // Fill the first row and first column with 0, as base case
        for (int i = 0; i < n + 1; i++) {
            t[0][i] = 0; // No characters in one string, so length is 0
            t[i][0] = 0; // No characters in the other string, so length is 0
        }

        // Fill the DP table using the given recurrence relation
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // If characters match between the original and reversed string
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    // Include the character and move diagonally in the table
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    // Take the maximum value from the left or top cell
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // The last cell contains the length of the longest palindromic subsequence
        return t[n][n];
    }
}
