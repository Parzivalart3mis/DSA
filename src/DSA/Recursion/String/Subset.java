package DSA.Recursion.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    // Printing sunsets
    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i)); // Copying the ith list from outer to internal
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }

    // Printing sunsets with adjacent duplicate elements
    static List<List<Integer>> subsetDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // If my current and previous element is same, then start = end + 1
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j)); // Copying the jth list from outer to internal
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
