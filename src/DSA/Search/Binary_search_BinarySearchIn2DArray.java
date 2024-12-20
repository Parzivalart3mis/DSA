package DSA.Search;

public class Binary_search_BinarySearchIn2DArray {
    public int[] searchRange(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            }
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
