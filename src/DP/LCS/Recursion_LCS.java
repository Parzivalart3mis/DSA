package DP.LCS;

public class Recursion_LCS {
    public int longestCommonSubsequence(String text1, String text2, int  n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (text1.charAt(n-1) == text2.charAt(m-1)) {
            return 1 + longestCommonSubsequence(text1, text2, n-1, m-1);
        }
        else {
            return Math.max(longestCommonSubsequence(text1, text2, n-1, m), longestCommonSubsequence(text1, text2, n, m-1));
        }
    }
}