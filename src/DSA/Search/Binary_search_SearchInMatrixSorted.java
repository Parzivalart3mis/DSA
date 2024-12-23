package DSA.Search;

public class Binary_search_SearchInMatrixSorted {
    // Search in the row provided, between the columns provided
    public int[] binary_search(int[][] matrix, int row, int cStart, int cEnd,  int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            else if (matrix[row][mid] < target) {
                cStart = mid + 1;
            }
            else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
    public int[] searchInSortedMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // be cautious over here, matrix may be empty

        if (rows == 1) {
            return binary_search(matrix, 0, 0, cols - 1, target);
        }
        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        // Run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) { // While this is true, it will have more than 2 rows
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }
            if (matrix[mid][cMid] < target) {
                rStart = mid;
            }
            else {
                rEnd = mid;
            }
        }

        // Now we have 2 rows
        // Check whether the target is in the col of 2 rows
        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }
        if (rStart + 1 < rows && matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

        // Search in 1st half
        if (cMid - 1 >= 0 && target <= matrix[rStart][cMid - 1]) {
            return binary_search(matrix, rStart, 0, cMid - 1, target);
        }
        // Search in 2st half
        if (cMid + 1 < cols && target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binary_search(matrix, rStart, cMid + 1, cols - 1, target);
        }
        // Search in 3st half
        if (cMid - 1 >= 0 && target <= matrix[rStart + 1][cMid - 1]) {
            return binary_search(matrix, rStart + 1, 0, cMid - 1, target);
        }
        // Search in 4st half
        if (cMid + 1 < cols) {
            return binary_search(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
        return new int[]{-1, -1};
    }
}
