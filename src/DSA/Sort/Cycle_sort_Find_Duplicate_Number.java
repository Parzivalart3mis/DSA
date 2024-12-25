package DSA.Sort;

public class Cycle_sort_Find_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] != i + 1) {
                int correct_index = nums[i] - 1;
                if (nums[i] != nums[correct_index]) {
                    int temp = nums[i];
                    nums[i] = nums[correct_index];
                    nums[correct_index] = temp;
                }
                else {
                    return nums[i];
                }
            }
            else {
                i++;
            }
        }
        return -1;
    }
}
