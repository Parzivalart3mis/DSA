package DSA.Sort;

public class Cycle_sort_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        int n = nums.length;
        int[] result = new int[2];

        while (i < n) {
            int correct_index = nums[i] - 1;
            if (nums[i] != nums[correct_index]) {
                int temp = nums[i];
                nums[i] = nums[correct_index];
                nums[correct_index] = temp;
            }
            else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                result[0] = nums[j];
                result[1] = j + 1;
            }
        }
        return result;
    }
}
