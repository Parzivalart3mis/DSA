package DSA.Search;

public class Binary_search_PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) { // You are in decreasing part of the array, this may be the answer, but lets look at left. This is why end is not mid - 1
                end = mid;
            }
            else { // You are in ascending part of the array
                start = mid + 1;
            }
        }
        return start;
    }
}
