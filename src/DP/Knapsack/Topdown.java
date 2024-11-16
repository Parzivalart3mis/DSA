package DP.Knapsack;
import static java.lang.Math.max;

//Top-down approach
//Changing recursion function calls to matrix "t" iterations
public class Topdown {
    int[][] t;
    public int knapsack(int[] wt, int[] val, int w, int n) {
        t = new int[n+1][w+1];
        //Initializing the matrix with 0 (base condition of recursion)
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