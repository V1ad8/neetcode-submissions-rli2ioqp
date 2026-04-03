class Solution {
    public int recursive(int n, int[] dp) {
        if (n < 3) {
            dp[n] = n;
        } else if (dp[n] == 0) {
            dp[n] = recursive(n - 1, dp) + recursive(n - 2, dp);
        }

        return dp[n];
    }

    public int climbStairs(int n) {
        return recursive(n, new int[n + 1]);
    }
}
