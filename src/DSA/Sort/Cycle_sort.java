package DSA.Sort;

// This code is for range [1, n]

public class Cycle_sort {
    public void cycleSort(int[] arr) {
        int n= arr.length;
        int i  = 0;
        while (i < n) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else {
                i++;
            }
        }
    }
}
