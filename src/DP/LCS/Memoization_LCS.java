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

    public int longestCommonSubsequence(String text1, String text2, int  m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (t[m][n] != -1) {
            return t[m][n];
        }

        if (text1.charAt(m-1) == text2.charAt(n-1)) {
            return t[m][n] = 1 + longestCommonSubsequence(text1, text2, m-1, n-1);
        }
        else {
            return t[m][n] = Math.max(longestCommonSubsequence(text1, text2, m, n-1), longestCommonSubsequence(text1, text2, m-1, n));
        }
    }
}