package DSA.Recursion.Easy;

public class ReverseNumber {
    static int sum = 0;
    static void reverse(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        sum = (sum * 10) + rem;
         reverse(n / 10);
    }
}