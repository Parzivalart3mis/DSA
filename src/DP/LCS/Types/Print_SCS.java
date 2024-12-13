package DP.LCS.Types;

public class Print_SCS {
    public String print_SCS(String str1, String str2, int m, int n) {
        // Step 1: Create a DP table to store lengths of the LCS for substrings
        int[][] t = new int[m + 1][n + 1];

        // Step 2: Initialize the first row and column with 0 (base case)
        for (int i = 0; i < m + 1; i++) {
            t[i][0] = 0; // No characters in str2
        }
        for (int j = 0; j < n + 1; j++) {
            t[0][j] = 0; // No characters in str1
        }

        // Step 3: Fill the DP table using the LCS recurrence relation
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // Step 4: Backtrack to construct the SCS
        int i = m, j = n;
        StringBuilder s = new StringBuilder();

        while (i > 0 && j > 0) {
            // If characters match, include them in the SCS
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                s.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                // If characters don't match, include the character from the string
                // that contributes the greater value in the DP table
                if (t[i - 1][j] > t[i][j - 1]) {
                    s.append(str1.charAt(i - 1));
                    i--;
                } else {
                    s.append(str2.charAt(j - 1));
                    j--;
                }
            }
        }

        // Step 5: Include remaining characters from str1 (if any)
        while (i > 0) {
            s.append(str1.charAt(i - 1));
            i--;
        }

        // Step 6: Include remaining characters from str2 (if any)
        while (j > 0) {
            s.append(str2.charAt(j - 1));
            j--;
        }

        // Step 7: Reverse the result string and return
        return s.reverse().toString();
    }
}
