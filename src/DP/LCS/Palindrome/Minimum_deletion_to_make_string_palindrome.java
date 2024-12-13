package DP.LCS.Palindrome;

public class Minimum_deletion_to_make_string_palindrome {

    // Helper method to reverse the input string
    private String reverse(String s) {
        // Use StringBuilder to reverse the string
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString(); // Return the reversed string
    }

    // Method to calculate the minimum deletions required to make a string a palindrome
    public int minDeletionToPalindrome(String str, int n) {
        // Step 1: Reverse the string to find the longest common subsequence (LCS)
        String rev = reverse(str);

        // Step 2: Create a DP table to store lengths of the LCS for substrings
        int[][] t = new int[n + 1][n + 1];

        // Step 3: Initialize the first row and first column to 0 (base case)
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = 0; // No characters in one string
            t[0][i] = 0; // No characters in the other string
        }

        // Step 4: Fill the DP table using the LCS recurrence relation
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // If characters from the original string and reversed string match
                if (str.charAt(i - 1) == rev.charAt(j - 1)) {
                    // Include the character and add 1 to the result from the previous subproblem
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    // Take the maximum value from either the top or left cell
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // Step 5: Calculate the minimum deletions required
        // Min deletions = Length of string - Length of Longest Palindromic Subsequence (LCS)
        return n - t[n][n];
    }
}
