package DSA.Recursion.Easy;

public class CountZeros {
    static void count(int n) {
        helper(n, 0);
    }
    static int helper(int n, int c) {
        if (n == 0) {
            return c;
        }
        int rem = n % 10;
        if (rem == 0) {
            return helper(n / 10, c + 1);
        }
        return helper(n / 10, c);
    }
}