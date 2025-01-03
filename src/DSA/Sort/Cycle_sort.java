package DSA.Sort;

// This code is for range [1, n]

public class Cycle_sort {
    public void cycleSort(int[] arr) {
        int n= arr.length;
        int i  = 0;
        while (i < n) {
            int correct_index = arr[i] - 1; // Correct index, let's say element is 4, then correct index of 4 is 4 - 1 = 3
            if (arr[i] != arr[correct_index]) {
                int temp = arr[i];
                arr[i] = arr[correct_index];
                arr[correct_index] = temp;
            }
            else {
                i++;
            }
        }
    }
}
