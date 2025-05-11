import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/coin-change/description/
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1]; // lowest number of coins that needs to make up that amount i
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int j = 0;
            int min = Integer.MAX_VALUE;
            while (j < coins.length && coins[j] <= i) {
                if (dp[i - coins[j]] >= 0) {
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
                j++;
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print("(" + i + ", " + dp[i] + "), ");
        }
        return dp[amount];
    }

    public int coinChangeV2(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1]; // lowest number of coins that needs to make up that amount i
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int j = 0;
            while (j < coins.length && coins[j] <= i) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                j++;
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{474, 83, 404, 3}, 264));
    }
}
