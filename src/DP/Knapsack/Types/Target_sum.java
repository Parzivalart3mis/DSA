package DP.Knapsack.Types;

public class Target_sum {
    int[][] t; // DP table to store the number of ways to form a target sum

    // Function to find the number of ways to assign + and - signs to the numbers
    // such that their sum equals the target
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum_nums = 0; // Total sum of all elements in the array
        int zeroCount = 0; // Count of zeros in the array

        // Calculate the total sum of the array and count the number of zeros
        for (int num : nums) {
            sum_nums += num;
            if (num == 0) {
                zeroCount++; // Count zeros separately since they contribute to multiple combinations
            }
        }

        // If (sum_nums + target) is odd or target is greater than sum_nums, it's impossible to form the target
        if ((sum_nums + target) % 2 != 0 || Math.abs(target) > sum_nums) {
            return 0;
        }

        // Calculate s1 (subset sum) that needs to be formed from the array to achieve the target
        int s1 = (sum_nums + target) / 2;

        // Initialize the DP table
        t = new int[n + 1][s1 + 1];

        // Base case: There is always one way to form sum 0, which is by selecting no elements
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = 1;
        }

        // Base case: There are no ways to form a non-zero sum with zero elements
        for (int j = 0; j < s1 + 1; j++) {
            t[0][j] = 0;
        }

        // Fill the DP table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s1 + 1; j++) {
                if (nums[i - 1] <= j) {
                    // If the current element can be included in the subset sum
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                } else {
                    // If the current element cannot be included in the subset sum
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // Multiply the result by 2^zeroCount to account for all combinations of zeros
        // Each zero in the array doubles the number of possible combinations (either +0 or -0)
        return (int) (t[n][s1] * Math.pow(2, zeroCount));
    }
}
