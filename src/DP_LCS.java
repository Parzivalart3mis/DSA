import DP.LCS.*;
import DP.LCS.Types.*;

public class DP_LCS {
    public static void main(String[] args) {
        // Sample input for LCS
        String text1 = "abcabcdede"; // String 1
        String text2 = "ace"; // String 2
        int m_LCS = text1.length(); // Length of text1
        int n_LCS = text2.length(); // Length of text2

        // Testing Recursion approach
        Recursion_LCS recursion_LCS = new Recursion_LCS();
        int recursionLCSLength = recursion_LCS.longestCommonSubsequence(text1, text2, m_LCS, n_LCS);
        System.out.println("Length of Longest Common Subsequence using Recursion approach: " + recursionLCSLength);

        // Testing Memoization approach
        Memoization_LCS memoizationLcs = new Memoization_LCS();
        int memoizationLCSLength = memoizationLcs.longestCommonSubsequence(text1, text2, m_LCS, n_LCS);
        System.out.println("Length of Longest Common Subsequence using Memoization approach: " + memoizationLCSLength);

        // Testing Top-down approach
        Topdown_LCS topdownLcs = new Topdown_LCS();
        int topdownLCSLength = topdownLcs.longestCommonSubsequence(text1, text2, m_LCS, n_LCS);
        System.out.println("Length of Longest Common Subsequence using Top-down approach: " + topdownLCSLength);

        // --------------------------------------------------------------------------
        System.out.println("--------------------------------------------------------------------------");
        // --------------------------------------------------------------------------

        // Testing Longest Common Substring
        String s1 = "abcabcdede"; // String 1 for Substring
        String s2 = "bcdaqred"; // String 2 for Substring
        int m_LCStr = s1.length(); // Length of s1
        int n_LCStr = s2.length(); // Length of s2

        Longest_common_substring longestCommonSubstring = new Longest_common_substring();
        int longestCommonSubstringLength = longestCommonSubstring.longestCommonSubstr(s1, s2, m_LCStr, n_LCStr);
        System.out.println("Length of Longest Common Substring: " + longestCommonSubstringLength);

        // --------------------------------------------------------------------------

        // Testing Print LCS
        String lcsText1 = "acbcf"; // String 1 for Print LCS
        String lcsText2 = "abcdaf"; // String 2 for Print LCS
        int lcsM = lcsText1.length(); // Length of lcsText1
        int lcsN = lcsText2.length(); // Length of lcsText2

        Print_LCS printLCS = new Print_LCS();
        String lcsResult = printLCS.print_LCS(lcsText1, lcsText2, lcsM, lcsN);
        System.out.println("Longest Common Subsequence: " + lcsResult);

        // --------------------------------------------------------------------------

        // Testing Shortest Common Supersequence
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int str1_len = str1.length();
        int str2_len = str2.length();

        Shortest_common_supersequence shortestCommonSupersequence = new Shortest_common_supersequence();
        int shortestCommonSuperstringLength = shortestCommonSupersequence.shortestCommonSupersequence(str1, str2, str1_len, str2_len);
        System.out.println("Length of Shortest Common Supersequence: " + shortestCommonSuperstringLength);

        // --------------------------------------------------------------------------

        // Testing Minimum Number of Insertion and Deletion to Convert String "a" to String "b"

        String a = "heap";
        String b = "pea";
        int a_len = a.length();
        int b_len = b.length();

        Minimum_insertion_deletion_convert_string minimumInsertionDeletionConvertString = new Minimum_insertion_deletion_convert_string();
        int minimumNumInsertionDeletion = minimumInsertionDeletionConvertString.minOperations(a, b, a_len, b_len);
        System.out.println("Minimum Number of Insertion and Deletion: "+minimumNumInsertionDeletion);
    }
}