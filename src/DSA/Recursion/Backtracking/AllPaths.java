package DSA.Recursion.Backtracking;

import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        allPaths("",board,0,0);
        System.out.println("*********");
        int[][] path = new int[board.length][board[0].length];
        allPathsPrint("", board, 0, 0, path, 1);
    }

    static void allPaths(String p, boolean[][] maze, int r, int c) {
        // Boolean Matrix start at 0,0 and ends at maze.length - 1, maze[0].length - 1. Cell with false value is not accessible for travel
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }

        // I am considering this block in my path
        maze[r][c] = false;

        // Going DOWN
        if (r < maze.length - 1) {
            allPaths(p + "D", maze, r + 1, c);
        }
        // Going RIGHT
        if (c < maze[0].length - 1) {
            allPaths(p + "R", maze, r, c + 1);
        }
        // Going UP
        if (r > 0) {
            allPaths(p + "U", maze, r - 1, c);
        }
        // Going LEFT
        if (c > 0) {
            allPaths(p + "L", maze, r, c - 1);
        }

        // This line is where the function will be over
        // Before the function gets removed, also remove the changes that were made by that path
        maze[r][c] = true;
    }

    static void allPathsPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        // Boolean Matrix start at 0,0 and ends at maze.length - 1, maze[0].length - 1. Cell with false value is not accessible for travel
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]) {
            return;
        }

        // I am considering this block in my path
        maze[r][c] = false;
        path[r][c] = step;

        // Going DOWN
        if (r < maze.length - 1) {
            allPathsPrint(p + "D", maze, r + 1, c, path, step + 1);
        }
        // Going RIGHT
        if (c < maze[0].length - 1) {
            allPathsPrint(p + "R", maze, r, c + 1, path, step + 1);
        }
        // Going UP
        if (r > 0) {
            allPathsPrint(p + "U", maze, r - 1, c, path, step + 1);
        }
        // Going LEFT
        if (c > 0) {
            allPathsPrint(p + "L", maze, r, c - 1, path, step + 1);
        }

        // This line is where the function will be over
        // Before the function gets removed, also remove the changes that were made by that path
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
