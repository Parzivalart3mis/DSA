package DSA.Recursion.Sort;

public class QuickSort {
    static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {
            // Also a reason why if its already sorted, it will not swap
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        // Now my pivot is at the correct index, please sort the 2 halves now
        sort(nums, low, e);
        sort(nums, s, high);
    }
}
