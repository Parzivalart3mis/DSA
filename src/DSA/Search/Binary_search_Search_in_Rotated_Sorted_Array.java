package DSA.Search;

public class Binary_search_Search_in_Rotated_Sorted_Array {
    public int search_pivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[start] >= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int binary_search(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int pivot = search_pivot(nums);

        if (pivot == -1) {
            // Array is not rotated
            return binary_search(nums, target, 0, end);
        }

        if (nums[pivot] == target) {
            return pivot;
        }

        if (target >= nums[start]) {
            return binary_search(nums, target, start, pivot - 1);
        }

        return binary_search(nums, target, pivot + 1, end);
    }
}
