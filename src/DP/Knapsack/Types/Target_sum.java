package DP.Knapsack.Types;

public class Target_sum {
    int[][] t;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum_nums = 0;
        int zeroCount = 0;

        // Calculate the total sum of the array and count zeros
        for (int num : nums) {
            sum_nums += num;
            if (num == 0) {
                zeroCount++;
            }
        }

        // If (sum_nums + target) is odd or target is not achievable, return 0
        if ((sum_nums + target) % 2 != 0 || Math.abs(target) > sum_nums) {
            return 0;
        }
        int s1 = (sum_nums + target) / 2;

        t = new int[n+1][s1+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < s1+1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < s1+1; j++) {
                if (nums[i-1] <= j) {
                    t[i][j] = t[i-1][j-nums[i-1]] + t[i-1][j];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        // Multiply by 2^zeroCount to account for all combinations of zeros
        return (int) (t[n][s1] * Math.pow(2, zeroCount));
    }
}
