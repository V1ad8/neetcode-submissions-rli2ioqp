class Solution {
    public int rec(int n, int cost[], int dp[]) {
        if (n < 2) {
            dp[n] = 0;
        } else if (dp[n] == 0) {
            dp[n] = Math.min(rec(n - 1, cost, dp) + cost[n - 1],
                            rec(n - 2, cost, dp) + cost[n - 2]);
        }

        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        return rec(cost.length, cost, new int[cost.length + 1]);
    }
}
