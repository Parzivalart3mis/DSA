package DSA.Recursion.Array;

public class SortedArrayCheck {
    public boolean arraySortedOrNot(int[] arr) {
       return helper(arr, 0);
    }

    boolean helper(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] <= arr[i + 1]) {
            return helper(arr, i + 1);
        }
        return false;
    }
}
