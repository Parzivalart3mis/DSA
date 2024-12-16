import DSA.Search.Linear_search;

public class DSA_Search {
    public static void main(String[] args) {
        // Testing Top-down approach
        int[] arr = {23, 45, 1, 2, 8, 19, -3, 16, -11, 18};
        Linear_search linear_search = new Linear_search();

        // Linear Search Test
        boolean linearSearchResult = linear_search.linearSearch(arr, 19);
        if (linearSearchResult) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }

        // Minimum Element Test
        int min_num = linear_search.minNum(arr);
        System.out.println("Minimum element of array: " + min_num);

        // Maximum Element Test
        int max_num = linear_search.maxNum(arr);
        System.out.println("Maximum element of array: " + max_num);

        // 2D Array Search Test
        int[][] arr2 = {
                {23, 4, 1},
                {18, 12, 3, 9},
                {78, 99, 34, 56},
                {18, 12}
        };
        boolean searchIn2DArray = linear_search.Search_in_2d_array(arr2, 56);
        if (searchIn2DArray) {
            System.out.println("Element found in 2D array");
        } else {
            System.out.println("Element not found in 2D array");
        }

        // Find Numbers with Even Number of Digits Test
        int[] nums = {12, 345, 2, 6, 7896};
        int evenDigitNumbers = linear_search.findNumbers(nums);
        System.out.println("Count of numbers with even number of digits: " + evenDigitNumbers);

        // Maximum Wealth Test
        int[][] accounts = {
                {1, 2, 3},
                {3, 2, 1},
                {4, 5, 6},
                {7, 8, 9}
        };
        int maxWealth = linear_search.maximumWealth(accounts);
        System.out.println("Maximum wealth: " + maxWealth);
        // --------------------------------------------------------------------------
        System.out.println("--------------------------------------------------------------------------");
        // --------------------------------------------------------------------------
    }
}
