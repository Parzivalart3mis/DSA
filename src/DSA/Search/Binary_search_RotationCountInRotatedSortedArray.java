package DSA.Search;
import java.util.*;

public class Binary_search_RotationCountInRotatedSortedArray {
    public int findKRotation(List<Integer> nums) {
        int start = 0;
        int end = nums.size() - 1;

        while (start <= end) {
            // Calculate the middle index to divide the search range
            int mid = start + (end - start) / 2;

            // Check if the current middle element is the pivot (greater than its next element)
            if (mid < end && nums.get(mid) > nums.get(mid + 1)) {
                return mid + 1; // Pivot found at `mid`
            }
            // Check if the current middle element is less than its previous element
            // This means the pivot is `mid - 1`
            else if (mid > start && nums.get(mid) < nums.get(mid - 1)) {
                return mid; // Pivot found at `mid - 1`
            }
            // If the middle element is smaller than or equal to the start element,
            // the pivot lies in the left half of the array
            else if (nums.get(start) >= nums.get(mid)) {
                end = mid - 1; // Move the search range to the left half
            }
            // Otherwise, the pivot lies in the right half of the array
            else {
                start = mid + 1; // Move the search range to the right half
            }
        }
        return 0;
    }
}
