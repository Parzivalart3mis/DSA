package DP.Knapsack.Unbounded_Knapsack;

public class Coin_change_1 {
    int[][] t;
    public int maxCoinChange(int[] coins, int amount) {
        int n = coins.length;
        t = new int[n+1][amount+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < amount+1; j++) {
                if(coins[i-1] <= j) {
                    t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][amount];
    }
}
