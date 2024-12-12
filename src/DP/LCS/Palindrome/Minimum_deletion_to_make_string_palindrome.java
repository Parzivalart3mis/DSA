package DP.LCS.Palindrome;

public class Minimum_deletion_to_make_string_palindrome {
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public int minDeletionToPalindrome(String str, int n) {
        String rev = reverse(str);
        int[][] t = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            t[i][0] = 0;
            t[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str.charAt(i - 1) == rev.charAt(j - 1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return (n - t[n][n]);
    }
}
