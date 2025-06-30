package DSA.Recursion.Array;

public class LS {
    static int search(int arr[], int x) {
        return helper (arr, 0, x);
    }
    
    static int helper(int[] arr, int i, int x) {
        if (i == arr.length - 1 && arr[i] != x) {
            return -1;
        }
        
        if (arr[i] == x) {
            return i;
        }
        return helper(arr, i + 1, x);
    } 
    
    static ArrayList<Integer> list = new ArrayList<>();
    static int searchAllIndex(int[] arr, int i, int x) {
        if (i == arr.length - 1 && arr[i] != x) {
            return -1;
        }
        
        if (arr[i] == x) {
            return list.add(i);
        }
        return helper(arr, i + 1, x);
    } 
    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }
        // This will contain answer for that function call only
        if(arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = return findAllIndex(arr, target, index + 1);

        list.addAll(ansFromBelowCalls);
        
        return list;
    }
}
