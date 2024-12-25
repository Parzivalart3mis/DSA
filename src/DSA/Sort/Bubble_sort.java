package DSA.Sort;

public class Bubble_sort {
    public void bubbleSort(int[] arr) {
        boolean swapped;
        // Run the steps n - 1 times
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            swapped = false;
            // For each step, the max item will come out at the last respective index
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the item is smaller than the previous item
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }
            // If you did not swap for a particular value of "i", it means that the array is sorted, hence stop the program
            if (!swapped) {
                break;
            }
        }
    }
}
