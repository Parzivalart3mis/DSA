package DP.Knapsack.Types;

import java.util.ArrayList;
import static java.lang.Math.min;

public class Minimum_subset_sum_diff {
    boolean[][] t;
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int range = 0;
        int mn = Integer.MAX_VALUE;
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0;i<n;i++) {
            range = range + nums[i];
        }

        t = new boolean[n+1][range+1];

        for (int i=0; i<n+1;i++) {
            for(int j=0; j<range+1; j++) {
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }
        }

        for(int i =1;i<n+1;i++) {
            for(int j=1;j<range+1;j++) {
                if(nums[i-1]<=j) {
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        for(int j=1;j<(range+1)/2;j++) {
            if(t[n][j] == true) {
                arr.add(j);
            }
        }

        for(int i=0;i<arr.size();i++) {
            mn = min(mn, range-(2* arr.get(i)));
        }
        return mn;
    }
}
