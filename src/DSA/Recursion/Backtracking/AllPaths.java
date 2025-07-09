package DSA.Recursion.Backtracking;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        allPaths("",board,0,0);
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
}
