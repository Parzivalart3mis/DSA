import DSA.Search.Binary_search;
import DSA.Search.Binary_search_ceiling;
import DSA.Search.Binary_search_floor;
import DSA.Search.Linear_search;

public class DSA_Search {
    public static void main(String[] args) {
        Linear_search linear_search = new Linear_search();

        // Linear Search Test
        int[] arr = {23, 45, 1, 2, 8, 19, -3, 16, -11, 18};
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

        Binary_search binarySearch = new Binary_search();

        // Testing Binary Search
        int[] numsAsc = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        int result = binarySearch.binarySearch(numsAsc, target);
        if (result != -1) {
            System.out.println("Binary Search: Element found at index " + result);
        } else {
            System.out.println("Binary Search: Element not found.");
        }

        // Testing Order-Agnostic Binary Search (Ascending Order)
        int[] numsAscOrder = {2, 4, 6, 8, 10, 12, 14};
        target = 8;
        result = binarySearch.orderAgnosticBinarySearch(numsAscOrder, target);
        if (result != -1) {
            System.out.println("Order-Agnostic Binary Search (Ascending): Element found at index " + result);
        } else {
            System.out.println("Order-Agnostic Binary Search (Ascending): Element not found.");
        }

        // Testing Order-Agnostic Binary Search (Descending Order)
        int[] numsDescOrder = {15, 13, 11, 9, 7, 5, 3};
        target = 9;
        result = binarySearch.orderAgnosticBinarySearch(numsDescOrder, target);
        if (result != -1) {
            System.out.println("Order-Agnostic Binary Search (Descending): Element found at index " + result);
        } else {
            System.out.println("Order-Agnostic Binary Search (Descending): Element not found.");
        }

        // --------------------------------------------------------------------------
        System.out.println("--------------------------------------------------------------------------");
        // --------------------------------------------------------------------------


        Binary_search_ceiling binary_search_ceiling = new Binary_search_ceiling();

        // Test 1: Finding the ceiling of a target number
        int[] array = {2, 3, 5, 9, 14, 16, 18};
        int lookupValue = 15;
        int ceilingIndex = binary_search_ceiling.ceiling(array, lookupValue);
        if (ceilingIndex != -1) {
            System.out.println("Ceiling of " + lookupValue + " is " + array[ceilingIndex] + " at index " + ceilingIndex);
        } else {
            System.out.println("Ceiling of " + lookupValue + " does not exist in the array.");
        }

        // Test 2: Target is smaller than the smallest element
        lookupValue = 1;
        ceilingIndex = binary_search_ceiling.ceiling(array, lookupValue);
        if (ceilingIndex != -1) {
            System.out.println("Ceiling of " + lookupValue + " is " + array[ceilingIndex] + " at index " + ceilingIndex);
        } else {
            System.out.println("Ceiling of " + lookupValue + " does not exist in the array.");
        }

        // Test 3: Target is larger than the largest element
        lookupValue = 20;
        ceilingIndex = binary_search_ceiling.ceiling(array, lookupValue);
        if (ceilingIndex != -1) {
            System.out.println("Ceiling of " + lookupValue + " is " + array[ceilingIndex] + " at index " + ceilingIndex);
        } else {
            System.out.println("Ceiling of " + lookupValue + " does not exist in the array.");
        }

        // Test 4: Target exists in the array
        lookupValue = 9;
        ceilingIndex = binary_search_ceiling.ceiling(array, lookupValue);
        if (ceilingIndex != -1) {
            System.out.println("Ceiling of " + lookupValue + " is " + array[ceilingIndex] + " at index " + ceilingIndex);
        } else {
            System.out.println("Ceiling of " + lookupValue + " does not exist in the array.");
        }

        // --------------------------------------------------------------------------
        System.out.println("--------------------------------------------------------------------------");
        // --------------------------------------------------------------------------

        Binary_search_floor binary_search_floor = new Binary_search_floor();

        // Test 5: Finding the floor of a target number
        int[] array2 = {2, 3, 5, 9, 14, 16, 18};
        int lookupValue2 = 10;
        int floorIndex = binary_search_floor.floor(array2, lookupValue2);
        if (floorIndex >= 0 && floorIndex < array2.length) {
            System.out.println("Floor of " + lookupValue2 + " is " + array2[floorIndex] + " at index " + floorIndex);
        } else {
            System.out.println("Floor of " + lookupValue2 + " does not exist in the array.");
        }

        // Test 6: Target is smaller than the smallest element
        lookupValue2 = 1;
        floorIndex = binary_search_floor.floor(array2, lookupValue2);
        if (floorIndex >= 0 && floorIndex < array2.length) {
            System.out.println("Floor of " + lookupValue2 + " is " + array2[floorIndex] + " at index " + floorIndex);
        } else {
            System.out.println("Floor of " + lookupValue2 + " does not exist in the array.");
        }

        // Test 7: Target is larger than the largest element
        lookupValue2 = 15;
        floorIndex = binary_search_floor.floor(array2, lookupValue2);
        if (floorIndex >= 0 && floorIndex < array2.length) {
            System.out.println("Floor of " + lookupValue2 + " is " + array2[floorIndex] + " at index " + floorIndex);
        } else {
            System.out.println("Floor of " + lookupValue2 + " does not exist in the array.");
        }

        // Test 4: Target exists in the array
        lookupValue2 = 11;
        floorIndex = binary_search_floor.floor(array2, lookupValue2);
        if (floorIndex >= 0 && floorIndex < array2.length) {
            System.out.println("Floor of " + lookupValue2 + " is " + array2[floorIndex] + " at index " + floorIndex);
        } else {
            System.out.println("Floor of " + lookupValue2 + " does not exist in the array.");
        }
    }
}
