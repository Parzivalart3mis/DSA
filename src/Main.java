import DP.Knapsack.Knapsack;
public class Main {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int[] weights = {1, 2, 3, 8, 7, 4};
        int[] values = {20, 5, 10, 40, 15, 25};
        int capacity = 10;
        int n = weights.length;

        int maxProfit = knapsack.knapsack(weights, values, capacity, n);

        System.out.println("Maximum profit: " + maxProfit);  // Example output: Maximum profit: <calculated value>
    }
}
