class Solution {
    public int change(int[] coins, int amount, int idx, int dp[][]) {
        if (amount < 0 || idx < 0) {
            return (Integer.MAX_VALUE - 1);
        }

        if (amount == 0) {
            return 0;
        }

        if (dp[idx][amount] != (Integer.MAX_VALUE - 1)) {
            return dp[idx][amount];
        }

        dp[idx][amount] = Math.min(change(coins, amount, idx - 1, dp),
            1 + change(coins, amount - coins[idx], idx, dp));

        return dp[idx][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i ++) {
            Arrays.fill(dp[i], (Integer.MAX_VALUE - 1));
        }

        int ret = change(coins, amount, coins.length - 1, dp);

        return ret == (Integer.MAX_VALUE - 1) ? -1 : ret;
    }
}
