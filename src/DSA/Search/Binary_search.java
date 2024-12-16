// Kunal Kushwaha's Binary Search questions in algorithm video
package DSA.Search;

public class Binary_search {
    public int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            // int mid = (start + end) / 2; // This may exceed the Integer range, hence we can use below formula
            int mid = start + (end - start) / 2; // This formula prevents integer overflow when calculating the midpoint, which can happen with (start + end) / 2 for large values of start and end
            if (target > nums[mid]) {
                start = mid + 1;
            }
            else if (target < nums[mid]) {
                end = mid - 1;
            }
            else { // target == nums[mid]
                return mid;
            }
        }
        return -1; // Nothing found, hence, returning -1;
    }

    public int orderAgnosticBinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        boolean isAsc = nums[start] < nums[end];

        while (start <= end) {
            // int mid = (start + end) / 2; // This may exceed the Integer range, hence we can use below formula
            int mid = start + (end - start) / 2; // This formula prevents integer overflow when calculating the midpoint, which can happen with (start + end) / 2 for large values of start and end
            if (target == nums[mid]) {
                return mid;
            }
            if (isAsc) {
                if (target > nums[mid]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            else {
                if (target < nums[mid]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1; // Nothing found, hence, returning -1;
    }
}
