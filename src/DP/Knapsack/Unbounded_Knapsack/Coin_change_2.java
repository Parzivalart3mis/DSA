package DP.Knapsack.Unbounded_Knapsack;

import java.util.Arrays;

public class Coin_change_2 {
    int[][] t;
    int INT_MAX = Integer.MAX_VALUE;
    public int minCoinChange(int[] coins, int amount) {
        coins = Arrays.stream(coins).filter(coin -> coin > 0).toArray();
        int n = coins.length;
        if (n == 0) {
            return -1; // No valid coins
        }
        t = new int[n+1][amount+1];
        // Initialize the DP table
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if (j == 0) {
                    t[i][j] = 0; // If amount is 0, no coins are needed
                }
                if (i == 0) {
                    t[i][j] = INT_MAX - 1; // If no coins are available, it's impossible
                }
            }
        }

        // Fill the DP table for the first coin (using coin[0] because checking only for length 1)
        for (int j = 1; j < amount+1; j++) {
            if (j % coins[0] == 0) {
                t[1][j] = j / coins[0];
            } else {
                t[1][j] = INT_MAX - 1;
            }
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < amount+1; j++) {
                if (coins[i-1] <= j) {
                    t[i][j] = Math.min(1 + t[i][j-coins[i-1]], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][amount] >= INT_MAX - 1 ? -1 : t[n][amount];
    }
}
