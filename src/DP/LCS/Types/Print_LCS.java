package DP.LCS.Types;

public class Print_LCS {
    // Method to find the Longest Common Subsequence (LCS) of two strings
    public String print_LCS(String text1, String text2, int m, int n) {
        // Create a 2D array to store the lengths of LCS at each step
        int[][] t = new int[m + 1][n + 1];

        // Initialize the first row and column to 0 (Base case: empty string)
        for (int i = 0; i < m + 1; i++) {
            t[i][0] = 0; // LCS of any string with an empty string is 0
        }
        for (int j = 0; j < n + 1; j++) {
            t[0][j] = 0; // LCS of an empty string with any string is 0
        }

        // Fill the 2D array using dynamic programming approach
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // If characters match, increase the LCS length
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum of excluding the current character from either string
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // Initialize variables for backtracking the LCS from the bottom-right of the matrix
        int i = m;
        int j = n;
        StringBuilder s = new StringBuilder();

        // Backtrack to find the LCS characters
        while (i > 0 && j > 0) {
            // If characters match, it's part of the LCS
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                s.append(text1.charAt(i - 1)); // Add the character to the result
                i--; // Move diagonally up-left
                j--; // Move diagonally up-left
            } else {
                // If characters don't match, move in the direction of the larger value
                if (t[i - 1][j] > t[i][j - 1]) {
                    i--; // Move up if the top cell is larger
                } else {
                    j--; // Move left if the left cell is larger
                }
            }
        }

        // Reverse the StringBuilder to get the correct order of the LCS (backtracking gives it in reverse)
        return s.reverse().toString();
    }
}
