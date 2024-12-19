package DSA.Search;

public class Binary_search_SearchInMountainArray {
    public int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int binary_search(int[] arr, int target, int start, int end) {
        // Order agnostic binary search
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (isAsc) {
                if (arr[mid] < target) {
                    start = mid + 1;
                }
                else if (arr[mid] > target) {
                    end  = mid - 1;
                }
            }
            else {
                if (arr[mid] > target) {
                    start = mid + 1;
                }
                else if (arr[mid] < target) {
                    end  = mid - 1;
                }
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int peak = findPeak(arr);
        int val = binary_search(arr, target, 0, peak);
        if (val == -1) {
            val = binary_search(arr, target, peak + 1, end);
        }
        return val;
    }
}
