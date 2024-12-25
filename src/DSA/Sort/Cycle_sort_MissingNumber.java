package DSA.Sort;

public class Cycle_sort_MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correct_index = nums[i];
            if (nums[i] < n && nums[i] != nums[correct_index]) {
                int temp = nums[i];
                nums[i] = nums[correct_index];
                nums[correct_index] = temp;
            }
            else {
                i++;
            }
        }
        // Search for first missing number
        for (int j = 0; j < n; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        // Case 2: 'n' not in the array -> n = 4, nums = [1, 0, 3, 2]
        return n;
    }
}
