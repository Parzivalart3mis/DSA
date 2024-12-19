package DSA.Search;

public class Binary_search_SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // In the end of the loop, this will contain the max item from the array
            end += nums[i];
        }

        // Binary search
        while(start < end) {
            // Try for the middle as potential answer
             int mid = (start + end) / 2;

             // Calculate in how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    // You cannot add this is this subarray, make new one
                    // Say you add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                }
                else {
                    sum += num;
                }
            }

            if (pieces > k) {
                start = mid + 1;
            }
            else {
                end = mid;
            }

        }
        return end; // Here start will be equal to end
    }
}
