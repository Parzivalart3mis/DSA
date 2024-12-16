// Kunal Kushwaha's Linear Search questions
package DSA.Search;

public class Linear_search {
    public boolean linearSearch(int[] arr, int key) {
        if (arr.length == 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return true;
            }
        }
        return false;
    }

    public int minNum(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public int maxNum(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public boolean Search_in_2d_array(int[][] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == key) {
                    return true;
                }
            }
        }
        return false;
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        int countNum = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]  > 0) {
                count++;
                nums[i] = nums[i] / 10;
            }
            if (count % 2 == 0) {
                countNum++;
            }
            count = 0;
        }
        return countNum;
    }

    public int maximumWealth(int[][] accounts) {
        int max_wealth = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }
            if (max_wealth < wealth) {
                max_wealth = wealth;
            }
        }
        return max_wealth;
    }
}
