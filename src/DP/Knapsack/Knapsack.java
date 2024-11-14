package DP.Knapsack;
import static java.lang.Math.max;
import java.util.Arrays;

////Recursion
//public class Knapsack {
//    public int knapsack(int[] wt, int[] val, int w, int n) {
//        if (w == 0 || n == 0) {
//            return 0;
//        }
//        if (wt[n - 1] <= w) {
//            return max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
//        } else {
//            return knapsack(wt, val, w, n - 1);
//        }
//    }
//}

////Memoization
//public class Knapsack {
//    int n_max = 102; // n < 100
//    int w_max = 1002; // w < 1000
//    int[][] t;
//
//    public Knapsack() {
//        t = new int[n_max][w_max];
//        for (int i = 0; i < n_max; i++) {
//            Arrays.fill(t[i], -1); // Using Arrays.fill to initialize each row to -1
//        }
//    }
//
//    public int knapsack(int[] wt, int[] val, int w, int n) {
//        if (w == 0 || n == 0) {
//            return 0;
//        }
//        if (t[n][w] != -1) {
//            return t[n][w];
//        }
//        if (wt[n - 1] <= w) {
//            t[n][w] = max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
//        } else {
//            t[n][w] = knapsack(wt, val, w, n - 1);
//        }
//        return t[n][w];
//    }
//}

////Top-down approach
public class Knapsack {
    int[][] t;
    public int knapsack(int[] wt, int[] val, int w, int n) {
        t = new int[n+1][w+1];
        for (int i=0;i<n+1;i++) {
            for (int j=0;j<w+1;j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i=1;i<n+1;i++) {
            for (int j=1;j<w+1;j++) {
                if(wt[i-1]<=j){
                    t[i][j] = max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }
}