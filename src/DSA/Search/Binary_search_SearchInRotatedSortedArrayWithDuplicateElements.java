package DSA.Search;

public class Binary_search_SearchInRotatedSortedArrayWithDuplicateElements {
    public int search_pivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // Calculate the middle index to divide the search range
            int mid = start + (end - start) / 2;

            // Check if the current middle element is the pivot (greater than its next element)
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid; // Pivot found at `mid`
            }
            // Check if the current middle element is less than its previous element
            // This means the pivot is `mid - 1`
            else if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1; // Pivot found at `mid - 1`
            }

            // If elements at middle, start and end are equal, then skip the duplicates
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                // Skip the duplicates

                // First check if start is pivot, and if not, then skip start
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                // First check if end is pivot, and if not, then skip end
                if (nums[end] < nums[end - 1]) {
                    return end;
                }
                end--;
            }
            else if (nums[start] < nums[mid] || nums[mid] == nums[start] && nums[mid] > nums[end]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
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
