package DP.LCS.Types;

public class Minimum_insertion_deletion_convert_string {

    // Method to calculate the minimum number of insertions and deletions
    // required to convert string s1 into string s2
    public int minOperations(String s1, String s2, int m, int n) {
        // Create a 2D array to store lengths of longest common subsequence (LCS)
        int[][] t = new int[m + 1][n + 1];

        // Initialize the first column of the DP table (when str2 is empty, LCS length is 0)
        for (int i = 0; i < m + 1; i++) {
            t[i][0] = 0;
        }
  // Fill the rest of the table using dynamic programming approach
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // If characters match, add 1 to the previous diagonal value
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                // If characters don't match, take the maximum from left or top cell
                else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        // Initialize the first row of the DP table (when str1 is empty, LCS length is 0)
        for (int j = 0; j < n + 1; j++) {
            t[0][j] = 0;
        }

        // Fill the rest of the table using dynamic programming approach
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // If characters match, add 1 to the previous diagonal value
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                // If characters don't match, take the maximum from left or top cell
                else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        // Calculate number of deletions needed to remove non-LCS characters from s1
        int num_of_del = m - t[m][n];

        // Calculate number of insertions needed to add non-LCS characters from s2
        int num_of_ins = n - t[m][n];

        // Total operations are the sum of deletions and insertions
        int min_num = num_of_del + num_of_ins;

        return min_num;
    }
}
