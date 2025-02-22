package Greedy;

public class IndianCoinChange {
    public static void main(String[] args) {
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int amount = 92;
        System.out.println(findMin(coins.length - 1, coins, amount));
    }

    public static long findMin(int i, int[] coins, long amount) {
        if (i == -1) {
            if (amount == 0)
                return 0;
            else
                return Integer.MAX_VALUE;
        }
        long skip = findMin(i - 1, coins, amount);
        if (coins[i] > amount)
            return skip;
        long pick = 1 + findMin(i, coins, amount - coins[i]);
        return Math.min(skip, pick);
    }
}
