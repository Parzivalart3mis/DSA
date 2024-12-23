package DSA.Search;

public class Binary_search_SearchInMatrix {
    public int[] searchRange(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            // Case 1: target is at element, answer found
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            }
            // Case 2: If the element is smaller than target, it means
            if (matrix[row][col] < target) {
                row++;
            }
            else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}
