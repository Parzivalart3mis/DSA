package DSA.Search;

public class Binary_search_floor {
    public int floor(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        // Perform binary search to find the floor of the target
        while (start <= end) {
            // int mid = (start + end) / 2; // This may exceed the Integer range, hence we can use below formula
            int mid = start + (end - start) / 2; // This formula prevents integer overflow when calculating the midpoint, which can happen with (start + end) / 2 for large values of start and end
            // If target is greater than mid-element, the floor must be in the right half
            if (target > nums[mid]) {
                start = mid + 1;
            }
            // If target is smaller than mid-element, the floor must be in the left half
            else if (target < nums[mid]) {
                end = mid - 1;
            }
            // If target is equal to mid-element, return the mid-index as the floor
            else { // target == nums[mid]
                return mid;
            }
        }
        // If no exact match is found, return end as the index of the floor element
        // The end index will point to the largest element smaller than or equal to the target
        return end;
    }
}
