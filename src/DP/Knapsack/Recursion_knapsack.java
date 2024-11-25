package DP.Knapsack;
import static java.lang.Math.max;

//Recursion
public class Recursion_knapsack {
    public int knapsack(int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= w) {
            return max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
        } else {
            return knapsack(wt, val, w, n - 1);
        }
    }
}