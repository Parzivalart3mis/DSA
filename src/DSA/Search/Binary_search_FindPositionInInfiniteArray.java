package DSA.Search;

public class Binary_search_FindPositionInInfiniteArray {
    public int findPositionInInfiniteArray(int arr[], int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int newStart = end + 1;
            int newEnd = end + (end - start + 1) * 2;
            start = newStart;
            end = newEnd;
        }
        int val = binary_search(arr, target, start, end);
        return val;
    }
    public int binary_search(int[] arr, int target, int start, int end) {
        // We are not allowed to use arr.length -> This is done to mimic the concept of infinity array
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            }
            else if (target > arr[mid]) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
