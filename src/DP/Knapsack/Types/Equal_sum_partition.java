package DP.Knapsack.Types;

public class Equal_sum_partition {
    public boolean equalPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0)
            return false;
        else {
            int req_sum = sum / 2;
            boolean[][] t = new boolean[n + 1][req_sum + 1];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < req_sum + 1; j++) {
                    if (i == 0)
                        t[i][j] = false;
                    if (j == 0)
                        t[i][j] = true;
                }
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < req_sum + 1; j++) {
                    if (arr[i - 1] <= j) {
                        t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                    } else {
                        t[i][j] = t[i - 1][j];
                    }
                }
            }
            return t[n][req_sum];
        }
    }
}
