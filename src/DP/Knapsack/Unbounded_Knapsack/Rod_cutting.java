package DP.Knapsack.Unbounded_Knapsack;
// Same code as unbounded knapsack
// wt -> length
// val -> prices
// W -> N
// n -> len
public class Rod_cutting {
    int[][] t;
    public int rod(int[] length, int[] prices, int N) {
        int len = length.length;
        t = new int[len+1][N+1];
        for (int i = 0; i < len+1; i++) {
            for (int j = 0; j < N+1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < len+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (length[i-1] <= j) {
                    t[i][j] = Math.max(prices[i-1]+t[i][j-length[i-1]], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[len][N];
    }
}
