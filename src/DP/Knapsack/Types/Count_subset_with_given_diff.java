package DP.Knapsack.Types;

public class Count_subset_with_given_diff {
    int[][] t;
    public int countSubsets(int[] arr, int diff) {
        int n = arr.length;
        int sum_arr = 0;
        for (int i : arr) {
            sum_arr += i;
        }
        // If (sum_arr + diff) is odd, no valid partition exists
        if ((sum_arr + diff) % 2 != 0) {
            return 0;
        }

        int s1 = (sum_arr + diff) / 2;

        t = new int[n + 1][s1 + 1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < s1+1; j++) {
                if (i==0) {
                    t[i][j] = 0;
                }
                if (j==0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < s1+1; j++) {
                if(arr[i-1]<=j) {
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][s1];
    }
}
